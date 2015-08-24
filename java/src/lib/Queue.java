package lib;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

    private int N;      // size of current queue
    private Node head;  // beginning of queue
    private Node tail;  // end of queue
    
    /**
     * Initializes an empty queue.
     */
    public Queue() {
        head = null;
        tail = null;
        N = 0;
    }

    // helper inner class
    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }
    
    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return N;
    }
    
    /**
     * Tests whether this queue is empty.
     * @return true if and only if queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * Adds item to the end of this queue.
     * @param item to add
     * @return true if operation succeeds
     */
    public boolean offer(Item item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        N++;
        return true;
    }
    
    /**
     * Returns and removes the item at the beginning in this queue.
     * @return beginning item in this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue underflow");
        }
        Node originalHead = head;
        Item item = originalHead.item;
        originalHead = null;
        head = head.next;
        N--;
        return item;
    }
    
    /**
     * Returns (but not removes ) the item at the beginning in this queue.
     * @return beginning item in this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue underflow");
        }
        return head.item;
    }
    
    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<Item> {
        private Node node;
        
        public LinkedListIterator() {
            node = head;
        }
        
        @Override
        public boolean hasNext() {
            return node != null;
        }
        
        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("queue underflow");
            }
            Item item = node.item;
            node = node.next;
            return item;
        }
        
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
