package gmail.alexspush.service;

import java.util.List;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public interface IMainPage {

    void setNewItemName(String todoName);

    void hitEnter();

    List<String> getTodoItemNames();
}
