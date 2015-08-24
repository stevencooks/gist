/**
 * File: src/stack/StackBasic.java
 ************************************************************************
 * In Java:
 * <pre>Stack</pre> extends <pre>Vector</pre> which is synchronized and 
 * thus thread-safe, and thus relatively slow.
 * details @see {@link http://cs.lmu.edu/~ray/notes/stacks/ }
 * 
 * int     size()          // number of items in stack
 * boolean isEmpty()       // whether stack is empty
 * Item    push(Item item) // push item on top of stack
 * Item    pop()           // return and remove the top item in stack
 * Item    peek()          // return but not remove the top item
 ************************************************************************
 * personal implementation using one-linked list see {@link lib.Stack }
 */
package stack;

import lib.Stack;

public class StackBasic {
    
    public static void main(String[] args) {
        new StackBasic().run();
    }

    private void run() {
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(123);

        System.out.println(stack.peek());

        stack.pop();
        
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

    }

}
