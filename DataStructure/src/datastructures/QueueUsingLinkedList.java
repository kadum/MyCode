/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Mak
 */
public class QueueUsingLinkedList {

    public class LinkedList {

        int data;
        LinkedList head;
        LinkedList next;

        private LinkedList(int data) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public LinkedList getNext() {
            return next;
        }

        public void setNext(LinkedList next) {
            this.next = next;
        }
    }
    LinkedList front = null, rear = null;

    public void enQueue(int data) {
        LinkedList node = new LinkedList(data);

        if (rear != null) {
            rear.setNext(node);
        }
        rear = node;
        if (front == null) {
            front = rear;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public int deQueue() {
        int data=-1;
        if (isEmpty()) {
            System.out.println("q is empty");
        } else {
            data = front.getData();
            front = front.getNext();
            System.out.println("element deleted is " + data);

        }
        return data;
    }
}