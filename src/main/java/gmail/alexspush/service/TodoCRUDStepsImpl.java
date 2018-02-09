package gmail.alexspush.service;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoCRUDSteps;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class TodoCRUDStepsImpl implements ITodoCRUDSteps {

    private IMainPage mainPage = SelenideMainPage.INSTANCE;

    @Override
    public void userEntersTodoName(String todoName) {
        mainPage.setNewItemName(todoName);
        mainPage.hitEnter();
    }

    @Override
    public void userMarksItemAsComplete(String todoItemName) {
        mainPage.selectCheckBoxForItem(todoItemName);
    }

    @Override
    public void userDeletesItem(String todoItemName) {
        mainPage.clickDeleteButtonForItem(todoItemName);
    }

    @Override
    public void userUnMarksItemAsComplete(String todoItemName) {
        mainPage.unSelectCheckBoxForItem(todoItemName);
    }
}
