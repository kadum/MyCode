/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Mak
 */
public class SortingAlgorithms {

    //bubble sort
    // successively selecting smallest elements through exchange of adjacent elements
      public void bubble(int a[]) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length ; i++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    // selection sort
    // select the smallest element in every ith pass and swap it with a[i] from 
    // an array of a[i]...a[n-1] elements
    public void selectionSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = a[i];
                a[i] = a[k];
                a[k] = a[i];
            }
        }

    }
}
