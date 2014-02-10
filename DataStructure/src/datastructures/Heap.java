/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Mak
 */
public class Heap {

    public int[] array;
    public int heapType;
    public int count;
    public int capacity;

    public Heap( int heapType,  int capacity) {
        
        this.heapType = heapType;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getHeapType() {
        return heapType;
    }

    public void setHeapType(int heapType) {
        this.heapType = heapType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
