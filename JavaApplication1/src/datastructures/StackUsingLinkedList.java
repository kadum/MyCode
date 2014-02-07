/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;


import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * An implementation of the stack interface using singly-linked
 * nodes.
 */
public class StackUsingLinkedList  {
    private class Node {
        public Object data;
        public Node next;
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top = null;

    public void push(Object item) {
        top = new Node(item, top);
    }

    public Object pop() {
        Object item = peek();
        top = top.next; 
        return item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public int size() {
        int count = 0;
        for (Node node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }
}