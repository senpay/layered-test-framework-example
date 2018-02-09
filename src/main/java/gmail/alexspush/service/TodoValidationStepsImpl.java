package gmail.alexspush.service;

import java.util.List;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoValidationSteps;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoValidationStepsImpl implements ITodoValidationSteps {

    //TODO: make this PoM a singletone
    private IMainPage mainPage = new SelenideMainPage();

    @Override
    public void todoItemIsPresent(String todoName) {
        //My exploratory testing shown there was no pagination
        //so brute force method
        List<String> itemNames = mainPage.getTodoItemNames();
        assertTrue(itemNames.contains(todoName));
    }

    @Override
    public void todoItemMarkedCompeted(String todoName) {

    }

    @Override
    public void todoItemIsNotPresent(String todoItemName) {

    }

    @Override
    public void todoItemIsNotMarkedCompeted(String todoItemName) {

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
