package gmail.alexspush.test;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18
 *
 * There's very good reason why I had put this file into test layer
 * (usually one would find this next to implementation).
 *
 * Steps API is a service layer-level abstraction. Tests are the product and they shouldn't break
 * If code below changes I don't want my test to feel that.
 *
 * That is questionable decision, though (I can imagine several reason, all valid, why one
 * shouldn't do that)
 */
public interface ITodoCRUDSteps {

    void userEntersTodoName(String todoName);

    void userMarksItemAsComplete(String todoItemName);

    void userDeletesItem(String todoItemName);

    void userUnMarksItemAsComplete(String todoItemName);

}
