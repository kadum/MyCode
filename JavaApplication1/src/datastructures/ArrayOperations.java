/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import sun.misc.Sort;

/**
 *
 * @author Mak
 */
public class ArrayOperations {

    // Declare the class if any required by programme in array operations.
    public class MinMax {

        int min;
        int max;
    }
    MinMax minmax;

    Integer a[] ={1,2,3,3};
     java.util.List<Integer> list =  java.util.Arrays.asList(a);
             
   /* c++ code to find max occuring character in string

char maxOccuringChar(char* str)
{
    if(str == NULL)
        return NULL;
 
    int count[256] = {0};
    int maxOccuringChar = str[0];
    count[str[0]]++;
 
    for(int i=1; str[i]!='\0'; i++)
    {
        count[str[i]]++;
 
        if(count[maxOccuringChar] < count[str[i]])
            maxOccuringChar = str[i];
    }
 
    return maxOccuringChar;
}
*/ 
     
     //calculate Maximum difference between two elements in array which is present in array itself
     public int maxDifference(int a[]){
         int maxDiff = a[1] - a[0];
         int minDiff = a[0];
         for(int i = 0; i < a.length; i++){
             
             
         }
     }
    //Segregate 0s and 1s in an array
    //Time Complexity: O(n)
    public void seggregate(int a[]) {
        int start = 0;
        int end = a.length - 1;

        while (start < end) {
            while (a[start] == 0 && start < end) {
                start++;
            }
            while (a[end] == 1 && start < end) {
                end--;
            }
            if (start < end) {
                a[start] = 0;
                a[end] = 1;
                start++;
                end--;
            }       
        }
    }

    public MinMax findMinAndMaxElement(int a[]) {
        int n = a.length;
        if (n % 2 == 0) {
            if (a[0] > a[1]) {
                minmax.max = a[0];
                minmax.min = a[1];
            } else {
                minmax.max = a[1];
                minmax.min = a[0];
            }
        } else {
            minmax.max = a[0];
            minmax.min = a[0];
        }
        int i = 2;
        while (i < n - 1) {

            if (a[i] > a[i + 1]) {
                if (a[i] > minmax.max) {
                    minmax.max = a[i];
                    minmax.min = a[i + 1];
                }
            } else if (a[i + 1] > a[i]) {
                if (a[i + 1] > minmax.max) {
                    minmax.max = a[i + 1];
                    minmax.min = a[i];
                }

            }
            i += 2; // incremenet i by 2 everytime;
        }





        return null;
    }
    //More efficient array rotation using reversal algorithm
    // reveres by d elements (left rotate)
    /*
     * For arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
     A = [1, 2] and B = [3, 4, 5, 6, 7]
     Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
     Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
     Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
     */

    public void reverseArray(int a[], int d) {
        reverse(a, 0, d - 1);
        reverse(a, d, a.length - 1);
        reverse(a, 1, a.length);
    }

    //Rotata array by d elements
    //O(n*d)
    public void rotate(int a[], int d) {
        for (int i = 0; i < d; i++) {
            leftRotate(a, a.length);
        }
    }

    public void leftRotate(int a[], int n) {
        int temp = 0;
        int i = 0;
        temp = a[0];
        for (i = 0; i < n; i++) {

            a[i] = a[i + 1];
        }
        //after for loop i iwill reach to the end of loop
        a[i] = temp;

    }

    //reverse the array
    public void reverse(int a[], int start, int end) {
        start = 0;
        end = a.length;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    /* Function to get median of a sorted array */

    int median(int arr[], int n) {
        if (n % 2 == 0) {
            return (arr[n / 2] + arr[n / 2 - 1]) / 2;
        } else {
            return arr[n / 2];
        }
    }

    // n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list.
    //One of the integers is missing in the list. Write an efficient code to find the missing integer
    public int findMissing(int a[]) {
        int sum = 0;
        int n = a.length;
        sum = (n * (n + 1)) / 2;
        for (int i = 0; i < n; i++) {
            sum -= a[i];
        }
        return sum;

    }

    //Find the Number Occurring Odd Number of Times
    //Do bitwise XOR of all the element
    // o(n)
    public int getOccurence(int ap[]) {
        int i;
        int result = 0;
        for (i = 0; i < ap.length; i++) {
            result = result ^ ap[i];
        }
        return result;
    }
    //Given an array A[] and a number x, check for pair in A[] with sum as x

    public void findPairElementsEqualToSum(int[] arr, int sum) {

        java.util.Arrays.sort(arr, 0, arr.length);

        int len = arr.length;
        int start = 0;
        while (start < len) {
            if ((arr[start] + arr[len]) == sum) {
                System.out.println("element first" + arr[start]);
                System.out.println("element second" + arr[len]);
            }
            if ((arr[start] + arr[len]) < sum) {
                start++;
            } else {
                len--;
            }
        }
    }
}
