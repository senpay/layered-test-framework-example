package gmail.alexspush.test;

import java.util.List;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18
 *
 */
public interface ITodoCompositeSteps {

    void userCreatedTodoItem(String todoItemName);

    void userCompletedTodoItem(String todoItemName);

    List<String> userCreatedNumberOfItems(int numberOfItemsCreated);

    List<String> userCompletedNumberOfItems(List<String> todoItems, int numberOfItemsCompleted);

}
