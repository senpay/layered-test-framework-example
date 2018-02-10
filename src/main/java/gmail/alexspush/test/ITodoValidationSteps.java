package gmail.alexspush.test;

import java.util.List;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18

 */
public interface ITodoValidationSteps {

    void todoItemIsPresent(String todoName);

    void todoItemMarkedCompeted(String todoName);

    void todoItemIsNotPresent(String todoItemName);

    void todoItemIsNotMarkedCompeted(String todoItemName);

    void userDoesNotSeeItems(List<String> items);

    void userSeesItems(List<String> items);
}
