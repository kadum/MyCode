/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Mak
 */
public class Queue {

    int front, rear, capacity;
    int[] array;

    public Queue(int size) {
        front = -1;
        rear = -1;
        capacity = 0;
        array = new int[size];
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public void enQueue(int data) throws Exception {
        if (isEmpty()) {
            array[rear] = data;
            front = rear;
        }
        if (capacity == array.length) {
            throw new Exception("queue is full");
        } else {
            rear = (rear + 1) % array.length;
            array[rear] = data;
            capacity++;
        }

    }

    public void deQueue() {
        if (!isEmpty()) {
            if(front==rear){
                front=-1;
                rear=-1;
            }
            int temp = array[front];
            front = (front + 1) % array.length;
            capacity--;

        } else {
            System.out.println("queue is empty");
        }

    }
}
