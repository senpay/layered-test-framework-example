package gmail.alexspush.test;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18
 */
public class TodoListTest {


    //Why interface? Couple of reasons
    //First (and arguable) is that I want my test to be decoupled from concrete steps implementation
    //Second (undoubtable for me) is that I don't want to think about implementation just yet.
    //I want my test scenarios to dictate the steps API I need to implement.
    IGenericSteps genericSteps;
    ITodoCRUDSteps todoCRUDSteps;
    ITodoFilterSteps todoFilterSteps;
    ITodoValidationSteps todoValidationSteps;
    ITodoCompositeSteps todoCompositeSteps;

    @Before
    public void setUp() {
        //Here I am not specifying which url to open - staging/production/local.
        //In general case, test should know nothing about it
        //There're some prominent exceptions, but they are out of scope of this example
        genericSteps.openApplication();
    }

    /**
     * At this stage it is going to be simple scenario.
     * Let's assume thing we have on a business layer (which not yet exist at the moment) is called steps.
     *
     */
    @Test
    public void shouldBeAbleToAddNewTodoItem() {
        //Even with java-based test automation it never hurts to specify
        //What is given (i.e. things that put system into particular state)
        //What is an action under test
        //And where we do verify the outcome

        //Given
        //Not much here - setUp() is almost enough
        //it would be nice to extract this name generation to some
        //getItemName() method, but that is boring thing to do, so I won't do it
        final String todoItemName = "mySuperNiceAndPrettyRandomName";

        //When
        todoCRUDSteps.userEntersTodoName(todoItemName);

        //Then
        //Here we're making assumption that there were no such item before.
        //It can be easily addressed if we generate new name for each test
        //I will not add this implementation here as this is pretty straight-forward thing to do
        todoValidationSteps.todoItemIsPresent(todoItemName);
    }

    /**
     * I am using technique called "atomic cases"
     * It is probably most known (and most under-used) technique.
     *
     * Other approach would be to do "E2E flow" UI scenario.
     *
     * "E2E flow" UI scenarios are good as a local optimization technique
     * but lame as a communication mechanism
     *
     * Even though I am not using vanila BDD here, I think test should
     * provide information and that should be a priority.
     * Atomic test are good as they mostlikely have only one reason to failure,
     * Which should make it way easier to find failure source
     *
     * Speed, efficiency and other BS goes after that (for me)
     *
     */
    @Test
    public void shouldBeAbleToMarkTodoItemAsCompleted() {
        //Given
        final String todoItemName = "mySuperNiceAndExtraRandomName";
        //would be nice to reference prev. test here, wouldn't it?
        todoCompositeSteps.userCreatedTodoItem(todoItemName);

        //When
        todoCRUDSteps.userMarksItemAsComplete(todoItemName);

        //Then
        //Here we're making assumption that there were no such item before.
        //It can be easily addressed if we generate new name for each test
        //I will not add this implementation here as this is pretty straight-forward thing to do
        todoValidationSteps.todoItemMarkedCompeted(todoItemName);
    }

    /**
     * Let's see if it is clear to understand the test intent without my
     * comments
     *
     */
    @Test
    public void shouldBeAbleToUnMarkTodoItemAsCompleted() {
        //Given
        final String todoItemName = "mySuperNiceAndExtraRandomName";
        todoCompositeSteps.userCreatedTodoItem(todoItemName);
        todoCRUDSteps.userCompletedTodoItem(todoItemName);

        //When
        todoCRUDSteps.userUnMarksItemAsComplete(todoItemName);

        //Then
        todoValidationSteps.todoItemIsNotMarkedCompeted(todoItemName);
    }


    /**
     * Let's see if it is clear to understand the test intent without my
     * comments
     *
     */
    @Test
    public void shouldBeAbleToDeleteTodoItem() {
        //Given
        final String todoItemName = "mySuperNiceAndUltraRandomName";
        todoCompositeSteps.userCreatedTodoItem(todoItemName);

        //When
        todoCRUDSteps.userDeletesItem(todoItemName);

        //Then
        todoValidationSteps.todoItemIsNotPresent(todoItemName);
    }

    /**
     * This guys would be actually very good to be a parametrized test.
     * Didn't I say I am a lazy brat?
     *
     * Parametrized tests are too easy to implement by my standards,
     * so I will not bother with it here
     *
     * Also, from communication stand-point parametrised tests _may_ be
     * confusing to read (although that is not always the case)
     */
    @Test
    public void shouldShowOnlyActiveItemsIfActiveFilterApplied() {
        //At this stage we get into a gray area - "given" steps are
        //becoming more complicated that test itself.
        //I would consider this as a clear indicator that
        //This "state preparation" logic should be done outside the UI
        //Given
        final int numberOfItemsCreated = 6;
        final int numberOfItemsCompleted = 4;
        todoCompositeSteps.userCreatedNumberOfItems(numberOfItemsCreated);
        todoCompositeSteps.userCompletedNumberOfItems(numberOfItemsCompleted);

        //When
        todoFilterSteps.selectsActiveFilter();

        //Then
        todoValidationSteps.userSeesOnlyActiveItems();

    }

    /**
     * This guys would be actually very good to be a parametrized test.
     * Same as previous.
     */
    @Test
    public void shouldShowOnlyCompletedItemsIfCompletedFilterApplied() {
        //Given
        final int numberOfItemsCreated = 5;
        final int numberOfItemsCompleted = 2;
        todoCompositeSteps.userCreatedNumberOfItems(numberOfItemsCreated);
        todoCompositeSteps.userCompletedNumberOfItems(numberOfItemsCompleted);

        //When
        todoFilterSteps.selectsCompletedFilter();

        //Then
        todoValidationSteps.userSeesOnlyCompletedItems();
    }

    /**
     * This guys would be actually very good to be a parametrized test.
     * Same as previous.
     */
    @Test
    public void shouldShowAllItemsIfNoFilterApplied() {
        //Given
        final int numberOfItemsCreated = 5;
        final int numberOfItemsCompleted = 2;
        todoCompositeSteps.userCreatedNumberOfItems(numberOfItemsCreated);
        todoCompositeSteps.userCompletedNumberOfItems(numberOfItemsCompleted);

        //When
        todoFilterSteps.selectsAllFilter();

        //Then
        todoValidationSteps.userSeeAllCreatedItems();
    }
}
