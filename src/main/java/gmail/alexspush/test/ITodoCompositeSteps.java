package gmail.alexspush.test;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18
 *
 */
public interface ITodoCompositeSteps {

    void userCreatedTodoItem(String todoItemName);

    void userCompletedTodoItem(String todoItemName);

    void userCreatedNumberOfItems(int numberOfItemsCreated);

    void userCompletedNumberOfItems(int numberOfItemsCompleted);

}
