/**
 * unit test cases from {@link http://cs.lmu.edu/~ray/notes/stacks/ }
 */
package lib;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    
    protected Stack<String> stack;
    
    @Before
    public void setUp() throws Exception {
        stack = new Stack<>();
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testNewStackIsEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPushesToEmptyStack() {
        int N = 6;
        for (int i = 0; i < N; i++) {
            stack.push("abc");
        }
        assertFalse(stack.isEmpty());
        assertEquals(N, stack.size());
    }

    @Test
    public void testPushThenPeek() {
        String message = "hello";
        stack.push(message);
        int size = stack.size();
        assertEquals(stack.peek(), message);
        assertEquals(stack.size(), size);
    }

    @Test
    public void testPoppingDownToEmpty() {
        int numberOfPushes = (int)(Math.random() * 20 + 1);
        for (int i = 0; i < numberOfPushes; i++) {
            stack.push("zzz");
        }
        for (int i = 0; i < numberOfPushes; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
        assertEquals(stack.size(), 0);
    }

    @Test(expected=NoSuchElementException.class)
    public void testPopOnEmptyStack() {
        assertTrue(stack.isEmpty());
        stack.pop();
    }

    @Test(expected=NoSuchElementException.class)
    public void testPeekIntoEmptyStack() {
        assertTrue(stack.isEmpty());
        stack.peek();
    }

}
