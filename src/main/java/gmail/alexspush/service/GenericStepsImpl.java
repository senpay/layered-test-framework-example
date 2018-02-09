package gmail.alexspush.service;

import gmail.alexspush.driver.SelenideApplicationDriver;
import gmail.alexspush.test.IGenericSteps;

/**
 * Created by Alexander Pushkarev on 7.2.18.
 */
public class GenericStepsImpl implements IGenericSteps {

    //Some application driver to be here
    //At this stage it is not important which f*ckium it is.
    //In ideal world those classes would be instantiated through setters using IoC container or
    //any other smart way. Here I just will new them.
    private IApplicationDriver applicationDriver = new SelenideApplicationDriver();

    /**
     * The name is deliberately vague "openApplication"
     * Is it url or tiny client written in Java-Script is (or should be)
     * irrelevant provided same functionality is implemented
     */
    @Override
    public void openApplication() {
        //In this class/method the reason why we have three layers is not visible (yet?)
        applicationDriver.openApplication();
    }

    @Override
    public void closeApplication() {
        applicationDriver.closeApplication();
    }
}
