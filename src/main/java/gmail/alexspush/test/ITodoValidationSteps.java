package gmail.alexspush.test;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18

 */
public interface ITodoValidationSteps {

    void todoItemIsPresent(String todoName);

    void todoItemMarkedCompeted(String todoName);

    void todoItemIsNotPresent(String todoItemName);

    void todoItemIsNotMarkedCompeted(String todoItemName);

    void userSeeAllCreatedItems();

    void userSeesOnlyActiveItems();

    void userSeesOnlyCompletedItems();

}
