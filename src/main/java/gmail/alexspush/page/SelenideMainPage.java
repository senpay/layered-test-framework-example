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

    public static final SelenideMainPage INSTANCE = new SelenideMainPage();

    //Sometimes it may be a good idea to put such ids into properties or other config file
    private static final By NEW_FIELD_XPATH = By.xpath("//input[@id='new-todo']");
    private static final By TODO_ITEMS_XPATH = By.xpath("//div[@class='view']/label");
    private static final By COMPLETED_FILTER_LINK_XPATH = By.xpath("//a[text()='Completed']");
    private static final By ACTIVE_FILTER_LINK_XPATH = By.xpath("//a[text()='Active']");
    private static final By ALL_FILTER_LINK_XPATH = By.xpath("//a[text()='All']");

    //I am not sure those xpathes are correct from the AngularJS point of view
    //Have no idea which of ids/classes are generated
    private static final String CHECKBOX_ITEM_XPATH_TEMPLATE = "//div[(@class='view') and (.//label[text()='%s'])]/input[@type='checkbox']";
    private static final String DELETE_ITEM_XPATH_TEMPLATE = "//div[(@class='view') and (.//label[text()='%s'])]/button[@class='destroy']";
    private static final String TODO_ITEM_XPATH_TEMPLATE = "//div[@class='view']/label[text()='%s']";

    //Brute force and not Thread-Local implementation of Singletone
    //Lazy initialization not needed, will just use static field
    private SelenideMainPage() {
    }

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

    /**
     * It would be a good question about if we should have this logic (hover and then delete) in page
     * or in steps.
     *
     * Probably conceptually it may be considered a candidate for steps, but I think
     * there's a good point to have it in page
     *
     * For instance if this hover logic gets deleted it would be nice to avoid step changes
     * @param todoItemName
     */
    @Override
    public void clickDeleteButtonForItem(final String todoItemName) {
        hoverOverTodoItem(todoItemName);
        clickDeleteButton(todoItemName);
    }

    private SelenideElement findCheckBoxForItem(final String todoItemName) {
        final String checkBoxXpathString  = String.format(CHECKBOX_ITEM_XPATH_TEMPLATE, todoItemName);
        final By checkBoxXpath = By.xpath(checkBoxXpathString);
        return $(checkBoxXpath);
    }

    @Override
    public void clickCompletedLink() {
        $(COMPLETED_FILTER_LINK_XPATH).click();
    }

    @Override
    public void clickAllLink() {
        $(ALL_FILTER_LINK_XPATH).click();
    }

    @Override
    public void clickActiveLink() {
        $(ACTIVE_FILTER_LINK_XPATH).click();
    }

    private void hoverOverTodoItem(final String todoItemName) {
        final String todoItemXpathString  = String.format(TODO_ITEM_XPATH_TEMPLATE, todoItemName);
        final By todoItemXpath = By.xpath(todoItemXpathString);
        $(todoItemXpath).hover();
    }

    private void clickDeleteButton(final String todoItemName) {
        final String deleteBoxXpathString  = String.format(DELETE_ITEM_XPATH_TEMPLATE, todoItemName);
        final By deleteButtonXpath = By.xpath(deleteBoxXpathString);
        $(deleteButtonXpath).click();
    }

}
