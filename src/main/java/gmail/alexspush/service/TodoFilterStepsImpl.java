package gmail.alexspush.service;

import gmail.alexspush.page.SelenideMainPage;
import gmail.alexspush.test.ITodoFilterSteps;

/**
 * Created by Alexander Pushkarev on 10.2.18.
 */
public class TodoFilterStepsImpl implements ITodoFilterSteps {

    private IMainPage mainPage = SelenideMainPage.INSTANCE;

    @Override
    public void selectsCompletedFilter() {
        mainPage.clickCompletedLink();
    }

    @Override
    public void selectsAllFilter() {
        mainPage.clickAllLink();
    }

    @Override
    public void selectsActiveFilter() {
        mainPage.clickActiveLink();
    }
}
