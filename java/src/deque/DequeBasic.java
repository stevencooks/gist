/**
 * File: deque/DequeBasic.java
 * ------------------------------------------------
 * Deque is an interface which extends Queue. 
 * 
 * int     size();
 * boolean isEmpty();
 * 
 * void    addFirst(E e);
 * void    addLast(E e);
 * boolean offerFirst(E e);
 * boolean offerLast(E e);
 * 
 * E getFirst();
 * E getLast();
 * E peekFirst();
 * E peekLast();
 * 
 * E removeFirst();
 * E removeLast();
 * E pollFirst();
 * E pollLast();
 * 
 * ------------------------------------------------
 */
package deque;

import java.util.Deque;
import java.util.LinkedList;

public class DequeBasic {

    public static void main(String[] args) {
        new DequeBasic().run();
    }

    private void run() {
        collectionsNaming();
        queueNaming();
    }

    private void queueNaming() {
        Deque<String> deque = new LinkedList<>();
        deque.size();
        deque.isEmpty();
        deque.offerFirst("a");
        deque.offerLast("a");
        
        String a = deque.peekFirst(); 
        String b = deque.peekLast();
        
        String aa = deque.pollFirst();
        String bb = deque.pollLast();
        System.out.println(aa.equals(a));
        System.out.println(bb.equals(b));
    }

    private void collectionsNaming() {
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addLast("z");

        String a = deque.getFirst();
        String b = deque.getLast();

        String aa = deque.removeFirst();
        String bb = deque.removeLast();
        assert (aa.equals(a));
        assert (b.equals(bb));

    }

}
