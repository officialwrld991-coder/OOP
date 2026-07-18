package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    Stack myStack;

    @BeforeEach
    public void setUp() {
        myStack = new Stack();
    }

    @Test

    public void myStackIsEmpty() {
        myStack.createArray(5);

        assertTrue(myStack.isEmpty());
    }

    @Test
    public void myStackIsNotEmpty() {
        myStack.createArray(5);
        myStack.push("olanrewaju");

        assertFalse(myStack.isEmpty());
    }


    @Test
    public void iPushAInsideMyStack_IPopIt() {
        myStack.createArray(5);
        myStack.push("Banana");
        myStack.pop();

        assertTrue(myStack.isEmpty());
    }

    @Test
    public void iPushABInsideMyStack_IPopB() {
        myStack.createArray(5);
        myStack.push("Banana");
        myStack.push("Apple");
        assertEquals("Apple", myStack.pop());
    }

    @Test
    public void iPushABInsideMyStack_IPopAB() {
        myStack.createArray(5);
        myStack.push("Banana");
        myStack.push("Apple");
        assertEquals("Apple", myStack.pop());
        assertEquals("Banana", myStack.pop());
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void iPushABInsideMyStack_IPopABC() {
        myStack.createArray(5);
        myStack.push("Banana");
        myStack.push("Apple");
        assertEquals("Apple", myStack.pop());
        assertEquals("Banana", myStack.pop());
        assertThrows(EmptyStackException.class, () -> myStack.pop());
    }

    @Test
    public void iPushMoreThan5ElementInAStackOf5() {
        myStack.createArray(5);
        myStack.push("Banana");
        myStack.push("Apple");
        myStack.push("Grape");
        myStack.push("Orange");
        myStack.push("Watermelon");

        assertThrows(IllegalStateException.class, () -> {
            myStack.push("Lemon");
        });
    }

    @Test
    public void peekReturnsLastPushedElement () {
        myStack.createArray(5);
        myStack.push("Banana");
        myStack.push("Apple");
        myStack.push("Grape");
        myStack.pop();
        myStack.peek();

        assertEquals("Apple", myStack.peek());

    }

    @Test
    public void peekThrowsException_WhenStackIsEmpty() {
        myStack.createArray(5);
        myStack.push("Banana");
        myStack.pop();
        assertThrows(EmptyStackException.class, () -> myStack.peek());

    }

}


