/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Hashtable;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Mak
 */
public class StringOperations {

// find the permutation of the given string
    // better code at geeks for geek
    public static void wperm(String[] a, int n) {
        if (n == 1) {
            StringBuilder sb = new StringBuilder();
            for (String i : a) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());

            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            wperm(a, n - 1);
            swap(a, i, n - 1);
        }
    }

    private static void swap(String[] a, int i, int j) {
        String c;
        c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    /* public static void main(String[] args) {
     int N =3;
     String a = "Hello My Friends";
 
     String[] c = a.split("\\s+");
     wperm(c,3);
     }
     */
    //permutation of string
    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;

        }
        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0); // get the first character
        String remainder = str.substring(1); // remove the 1st character
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;

    }

    //reomove duplicates using hashtable
    /**
     *
     * @param s1
     * @return
     */
    public Hashtable removeDuplicates(String s1) {
        int n = s1.length();
        java.util.Hashtable h = new Hashtable();
        int i = 0;
        while (i < n) {
            if (!h.contains(s1.charAt(i))) {
                h.put(true, s1.charAt(i));
            } else {
                i++;
            }
            i++;
        }
        //using iterator and enumeration to iterate over the elements
        java.util.Enumeration e = h.elements();
        java.util.Iterator t = (java.util.Iterator) h.elements();
        while (t.hasNext()) {
            System.out.println(t.next());
        }
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
        return h;
    }

    //concat two strings
    public void concat(String s1, String s2) {
        String s3 = s1.concat(s2); /// :)

        int i = s1.length();
        int j = 0;
        for (j = 0; j < s2.length(); i++, j++) {
            s1.charAt(s2.charAt(j));
        }
        System.out.println("concatenated string " + s1);


    }
    // reverse 

    public void reverse(String s1) {
        int i = 0;
        char[] s = s1.toCharArray();
        int n = s.length - 1;
        while (i < n) {
            Character temp = null;
            temp = s[i];
            s[i] = s[n];
            s[n] = temp;
            i++;
            n--;
        }
    }

    public boolean palindrome(String s1) {
        char[] s = s1.toCharArray();
        int i = 0;
        int n = s.length - 1;

        while (i < n) {
            if (s[i] != s[n]) {
                System.out.println("not palindrome");
                return false;
            } else {
                i++;
                n--;
            }
        }
        return true;
    }

    //return substring from given string 
    public StringBuilder findSubstring(String s1, int m, int n) {
        int len = s1.length();
        StringBuilder s2 = null;
        for (int i = 0; i < len; i++) {
            if (i == m && m != n) {
                s2.append(s1.charAt(i));
                m++;
            }
        }
        return s2;
    }

    public boolean subString(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int i = 0;
        int j = 0;
        int k = 0;
        while (!s1.isEmpty()) {
            while (s1.charAt(i) != s2.charAt(0) && !s1.isEmpty()) {
                i++;
            }
            if (s1.isEmpty()) {
                return false;
            }
            k = i;
            while (s1.charAt(i) == s2.charAt(j) && !s2.isEmpty()) {
                i++;
                j++;
            }
            if (s2.isEmpty()) {
                System.out.println("substring found at location" + k);
                return true;
            }
            if (s1.isEmpty()) {
                System.out.println("substring not found");
                return false;
            }
            //i=k+1??? not sure 
            //j=0 ..?not sure
        }
        return false;
    }
}
