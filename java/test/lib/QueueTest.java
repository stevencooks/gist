/**
 * unit tests are from {@link http://cs.lmu.edu/~ray/notes/queues/ }
 */
package lib;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

    protected Queue<String> q;
    
    @Before
    public void setUp() throws Exception {
        q = new Queue<>(); }

    @After
    public void tearDown() throws Exception {
        q = null;
    }

    @Test
    public void testNewQueueIsEmpty() {
        assertTrue(q.isEmpty());
        assertEquals(q.size(), 0);
    }

    @Test
    public void testInsertsToEmptyQueue() {
        int numberOfInserts = 6;
        for (int i = 0; i < numberOfInserts; i++) {
            q.offer("zzz");
        }
        assertTrue(!q.isEmpty());
        assertEquals(q.size(), numberOfInserts);
    }

    @Test
    public void testEnqueueThenDequeue() {
        String message = "hello";
        q.offer(message);
        assertEquals(q.poll(), message);
    }

    @Test
    public void testEnqueueThenPeek() {
        String message = "hello";
        q.offer(message);
        int size = q.size();
        assertEquals(q.peek(), message);
        assertEquals(q.size(), size);
    }

    @Test
    public void testFiftyInThenFiftyOut() {
        Queue<Integer> q = new Queue<>();
        for (int i = 0; i < 50; i++) {
            q.offer(i);
        }
        for (int i = 0; i < 50; i++) {
            assertEquals(((Integer)q.poll()).intValue(), i);
        }
    }

    @Test
    public void testRemovingDownToEmpty() {
        int numberOfRemoves = (int)(Math.random() * 20 + 1);
        for (int i = 0; i < numberOfRemoves; i++) {
            q.offer("zzz");
        }
        for (int i = 0; i < numberOfRemoves; i++) {
            q.poll();
        }
        assertTrue(q.isEmpty());
        assertEquals(q.size(), 0);
    }
    
    @Test(expected=NoSuchElementException.class)
    public void testRemoveOnEmptyQueue() {
        assertTrue(q.isEmpty());
        q.poll();
    }

    @Test(expected=NoSuchElementException.class)
    public void testPeekIntoEmptyQueue() {
        assertTrue(q.isEmpty());
        q.poll();
    }

}
