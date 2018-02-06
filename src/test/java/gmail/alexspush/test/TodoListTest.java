package gmail.alexspush.test;

import gmail.alexspush.test.ITodoCRUDSteps;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Alexander Pushkarev.
 * apushkarev@workfusion.com
 * 6.2.18
 */
public class TodoListTest {

    IGenericSteps genericSteps;
    ITodoCRUDSteps todoCRUDSteps;

    @Before
    public void setUp() {
        genericSteps.openApplicationUrl();
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
        //Empty here - setUp() is enough

        //When
        todoCRUDSteps.enterTodoName("todoName");

        //Then
        //Here we're making assumption that there were no such item before.
        //It can be easily addressed if we generate new name for each test
        //I will not add this implementation here as this is pretty straight-forward thing to do
        todoCRUDSteps.todoPresentInAList("todoName");
    }
}
