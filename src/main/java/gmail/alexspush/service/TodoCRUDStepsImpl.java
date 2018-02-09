package gmail.alexspush.service;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoCRUDSteps;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoCRUDStepsImpl implements ITodoCRUDSteps {

    private IMainPage mainPage = new SelenideMainPage();

    @Override
    public void userEntersTodoName(String todoName) {
        mainPage.setNewItemName(todoName);
        mainPage.hitEnter();
    }

    @Override
    public void userMarksItemAsComplete(String todoItemName) {

    }

    @Override
    public void userDeletesItem(String todoItemName) {

    }

    @Override
    public void userCompletedTodoItem(String todoItemName) {

    }

    @Override
    public void userUnMarksItemAsComplete(String todoItemName) {

    }
}
