package gmail.alexspush.service;

import gmail.alexspush.test.ITodoCRUDSteps;
import gmail.alexspush.test.ITodoCompositeSteps;
import gmail.alexspush.test.ITodoValidationSteps;

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
        assumeTrue(todoValidationLogic.isItemPresentInAList(todoItemName));
    }

    @Override
    public void userCompletedTodoItem(String todoItemName) {
        crudSteps.userMarksItemAsComplete(todoItemName);
        assumeTrue(todoValidationLogic.isTodoItemMarkedCompeted(todoItemName));
    }

    @Override
    public void userCreatedNumberOfItems(int numberOfItemsCreated) {

    }

    @Override
    public void userCompletedNumberOfItems(int numberOfItemsCompleted) {

    }
}
