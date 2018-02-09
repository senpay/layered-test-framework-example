package gmail.alexspush.service;

import java.util.List;

import gmail.alexspush.page.SelenideMainPage;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoValidationLogic {

    //TODO: make this PoM a singletone
    private IMainPage mainPage = SelenideMainPage.INSTANCE;;

    boolean isItemPresentInAList(final String todoName) {
        //My exploratory testing shown there was no pagination
        //so brute force method
        List<String> itemNames = mainPage.getTodoItemNames();
        return itemNames.contains(todoName);
    }

    boolean isTodoItemMarkedCompeted(final String todoName) {
        return mainPage.isCheckBoxItemSelected(todoName);
    }
}
