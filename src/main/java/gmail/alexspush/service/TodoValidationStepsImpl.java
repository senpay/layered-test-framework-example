package gmail.alexspush.service;

import java.util.List;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoValidationSteps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoValidationStepsImpl implements ITodoValidationSteps {

    private TodoValidationLogic todoValidationLogic = new TodoValidationLogic();

    @Override
    public void todoItemIsPresent(String todoName) {
        assertTrue(todoValidationLogic.isItemPresentInAList(todoName));
    }

    @Override
    public void todoItemMarkedCompeted(String todoName) {
        assertTrue(todoValidationLogic.isTodoItemMarkedCompeted(todoName));
    }

    @Override
    public void todoItemIsNotPresent(String todoItemName) {
        assertFalse(todoValidationLogic.isItemPresentInAList(todoItemName));
    }

    @Override
    public void todoItemIsNotMarkedCompeted(String todoItemName) {
        assertFalse(todoValidationLogic.isTodoItemMarkedCompeted(todoItemName));
    }

    @Override
    public void userSeeAllCreatedItems() {

    }

    @Override
    public void userSeesOnlyActiveItems() {

    }

    @Override
    public void userSeesOnlyCompletedItems() {

    }


}
