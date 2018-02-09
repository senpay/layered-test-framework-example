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

    //I am not sure those xpathes are correct from the AngularJS point of view
    //Have no idea which of ids/classes are generated
    private static final String CHECKBOX_ITEM_XPATH_TEMPLATE = "//div[(@class='view') and (.//label[text()='%s'])]/input[@type='checkbox']";
    private static final String DELETE_ITEM_XPATH_TEMPLATE = "//div[(@class='view') and (.//label[text()='%s'])]/button[@class='destroy']";

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
        final ElementsCollection todoItems = $$(TODO_ITEMS_XPATH);
        final List<String> todoItemNames = todoItems
                .stream()
                .map(SelenideElement::getText)
                .collect(Collectors.toList());
        return todoItemNames;
    }

    @Override
    public void selectCheckBoxForItem(final String todoItemName) {
        //Chaining like this is not nice, but does not matter now
        //Just remember that this is a code smell very NPE prone
        findCheckBoxForItem(todoItemName).setSelected(true);
    }
    @Override
    public void unSelectCheckBoxForItem(final String todoItemName) {
        //Chaining like this is not nice, but does not matter now
        //Just remember that this is a code smell very NPE prone
        findCheckBoxForItem(todoItemName).setSelected(false);
    }


    @Override
    public boolean isCheckBoxItemSelected(final String todoItemName) {
        //Chaining like this is not nice, but does not matter now
        //Just remember that this is a code smell very NPE prone
        return findCheckBoxForItem(todoItemName).isSelected();
    }

    @Override
    public void clickDeleteButtonForItem(String todoItemName) {
        final String checkBoxXpathString  = String.format(DELETE_ITEM_XPATH_TEMPLATE, todoItemName);
        By deleteButtonXpath = By.xpath(checkBoxXpathString);
        $(deleteButtonXpath).click();
    }

    private SelenideElement findCheckBoxForItem(final String todoItemName) {
        final String checkBoxXpathString  = String.format(CHECKBOX_ITEM_XPATH_TEMPLATE, todoItemName);
        By checkBoxXpath = By.xpath(checkBoxXpathString);
        return $(checkBoxXpath);
    }
}
