/**
 * File: src/lib/Stack.java
 ************************************************************************
 * Single-linked list based implementation.
 * 
 ************************************************************************
 */
package lib;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private int N; // size of stack
    private Node dummyHead; // dummy head node on top of stack's top

    // helper static nested class
    private class Node {
        private Item item; // item stored inside this node
        private Node next; // node next to this node
    }

    /** Initializes an empty stack. */
    public Stack() {
        dummyHead = new Node();
        N = 0;
    }

    /**
     * Returns number of items in this stack.
     * @return the number of items in this stack.
     */
    public int size() {
        return N;
    }

    /**
     * Tests whether this stack has no items.
     * @return <code>true</code> if and only if this stack has no items;
     *         <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Pushes the item on top of this stack.
     * @param item the item to push
     * @return the <code>item</code> argument.
     */
    public Item push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = dummyHead.next;
        dummyHead.next = node;
        N++;
        return item;
    }

    /**
     * Removes and returns the item on top of this stack.
     * @return the <code>item</code> on the top
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        }
        Node node = dummyHead.next;
        dummyHead.next = node.next;
        Item item = node.item;
        node = null;
        N--;
        return item;
    }

    /**
     * Returns (but not removes) the item on the top of this stack.
     * @return the <code>item</code> on the top of stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("stack underflow");
        }
        return dummyHead.next.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node node;

        public ListIterator() {
            node = dummyHead;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            node = node.next;
            return node.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("a");
        s.push("b");
        for (String string : s) {
            System.out.println(string);
        }
        System.out.println(s.peek());
        s.pop();
        s.pop();
        System.out.println(s.isEmpty());
    }

}
