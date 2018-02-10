package gmail.alexspush.service;

import java.util.ArrayList;
import java.util.List;

import gmail.alexspush.test.ITodoCRUDSteps;
import gmail.alexspush.test.ITodoCompositeSteps;

import static gmail.alexspush.utils.TestUtils.generateItemName;
import static org.junit.Assume.assumeTrue;

/**
 * The idea of this composite is to create some abstraction
 * if "state-creating" steps. They more or less using other steps
 * but should fail with different exception if necessary
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoCompositeStepsImpl implements ITodoCompositeSteps {

    private ITodoCRUDSteps crudSteps = new TodoCRUDStepsImpl();
    //I use here concrete type as I want some method from it
    //Looks ugly but will leave it as is for now
    private TodoValidationLogic todoValidationLogic = new TodoValidationLogic();

    @Override
    public void userCreatedTodoItem(String todoItemName) {
        crudSteps.userEntersTodoName(todoItemName);
        //Using asume here so exception in step preparation would look
        //different from typical assertion
        assumeTrue(todoValidationLogic.isItemPresentInAList(todoItemName));
    }

    @Override
    public void userCompletedTodoItem(String todoItemName) {
        crudSteps.userMarksItemAsComplete(todoItemName);
        assumeTrue(todoValidationLogic.isTodoItemMarkedCompeted(todoItemName));
    }

    @Override
    public List<String> userCreatedNumberOfItems(int numberOfItemsCreated) {
        final List<String> todoItemNames = new ArrayList<>();
        for (int i = 0; i < numberOfItemsCreated; i++) {
            final String todoItemName = generateItemName();
            userCreatedTodoItem(todoItemName);
            todoItemNames.add(todoItemName);
        }
        return todoItemNames;
    }

    @Override
    public List<String> userCompletedNumberOfItems(List<String> todoItems, int numberOfItemsCompleted) {
        List<String> todoItemsToBeCompleted = todoItems.subList(0, numberOfItemsCompleted);
        for (String todoItem : todoItemsToBeCompleted) {
            userCompletedTodoItem(todoItem);
        }
        return todoItemsToBeCompleted;
    }
}
