/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.*;

/**
 *
 * @author Mak
 */
public class DynamicProgramming {

    //fibnacci serios
    public int fibo(int n) {
        if (n == 0) {
            return 0;

        }
        if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
    //fibonaccci using dynamic programming to store the value of computed result of subproblems 
    // that will be used later in the computation
    /*
     Memoization (Top Down): The memoized program for a problem is similar to the recursive
     * version with a small modification that it looks into a lookup table before computing 
     * solutions. We initialize a lookup array with all initial values as NIL. Whenever we
     * need solution to a subproblem, we first look into the lookup table. If the precomputed 
     * value is there then we return that value, otherwise we calculate the value and put the
     * result in lookup table so that it can be reused later
     */
    public int lookup[] = null;

    public void initialize() {
        int MAX = 100;

        for (int i = 0; i < MAX; i++) {
            lookup[i] = -99;
        }
    }

    public int fibo2(int n) {
        if (lookup[n] == -99) {
            if (n <= 1) {
                lookup[n] = n;
            } else {
                lookup[n] = fibo2(n - 1) + fibo2(n - 2);
            }
        }
        return lookup[n];
    }
    //OR
    int MAX = -1;
    int[] fib = new int[MAX];

    int fibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (fib[i] != 0) {
            return fib[i]; // Return cached result.
        }
        fib[i] = fibonacci(i - 1) + fibonacci(i - 2); // Cache result
        return fib[i];
    }
}
