package gmail.alexspush.page;

import java.util.List;
import java.util.stream.Collectors;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import gmail.alexspush.service.IMainPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class SelenideMainPage implements IMainPage {

    private static final By NEW_FIELD_XPATH = By.xpath("//input[@id='new-todo']");
    private static final By TODO_ITEMS_XPATH = By.xpath("//div[@class='view']/label");

    @Override
    public void setNewItemName(String todoName) {
        $(NEW_FIELD_XPATH).setValue(todoName);

    }

    @Override
    public void hitEnter() {
        $(NEW_FIELD_XPATH).pressEnter();
    }

    @Override
    public List<String> getTodoItemNames() {
        ElementsCollection todoItems = $$(TODO_ITEMS_XPATH);
        List<String> todoItemNames = todoItems
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        return todoItemNames;
    }
}
