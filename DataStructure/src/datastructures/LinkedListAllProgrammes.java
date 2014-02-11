/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.Hashtable;
import java.util.Stack;

/**
 *
 * @author Mak
 */
public class LinkedListAllProgrammes {

    public class Node {

        int data;
        Node next;
        Node prev; //for double linked list

        public Node(int data) {
            this.data = data;
        }

        public void appendToEnd(int data) {
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            Node tail = new Node(data);
            n.next = tail;
        }

        public Node deleteFromFront(int data) {
            Node n = this;
            if (n.data == data) {
                return this.next;
            }
            while (n != null) {
                if (n.next.data == data) {
                    n.next = n.next.next;
                }
                n = n.next;
            }
            return this;

        }
        //reverse the linked list

        public Node reverse(Node node) {
            Node p = null;
            Node q = node.next;
            Node r = q.next;
            while (q != null) {
                q.next = p;
                p.next = q;
                q.next = r;
                if (r != null) {
                    r = r.next;

                }
            }
            return p;
        }
        //compare the two linkedl lists

        public boolean compareLists(Node node1, Node node2) {
            while (node1 != null && node2 != null) {
                if (node1.data == node2.data) {
                    node1 = node1.next;
                    node2 = node2.next;
                }
            }
            if (node1 == null && node2 == null) {
                return true;
            }
            return false;
        }
        //remove duplicates using HashTable from the linked list
        // O(N) time- N is the no of nodes

        public void removeDuplicates(Node node) {
            Hashtable t = new Hashtable();
            Node prev = null;
            while (node != null) {
                if (t.containsKey(node.data)) {
                    prev.next = node.next;
                } else {
                    t.put(node.data, true);
                    prev = node;
                }
                node = node.next;
            }

        }

        // to reverse the double linked list just swap the previous and next pointer
        /*
         Time Complexity: O(n)
         We can also swap data instead of pointers to reverse the Doubly Linked List.
         * Method used for reversing array can be used to swap data. Swapping data can be
         * costly compared to pointers if size of data item(s) is more.
         */
        public void reverseDoubleLinkedlist(Node head) {
            Node temp = null;
            Node current = head;
            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }
            if (temp != null) {
                head = temp.prev;
            }
        }

        //Merge sorted linked list using recursion
        public Node mergetTwoSortedLinkedList(Node a, Node b) {
            Node result = null;
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;

            }
            if (a.data <= b.data) {
                result = a;
                result.next = mergetTwoSortedLinkedList(a.next, b);
            } else {
                result = b;
                result.next = mergetTwoSortedLinkedList(a, b.next);
            }
            return result;
        }

        //flatten the linked list
        public Node flatten(Node node) {
            if (node == null || node.next == null) {
                return node;
            }
            //merge this list with list on the right side
            return mergetTwoSortedLinkedList(node, flatten(node.next));
        }

        //addition of two number represented by linked list
        public Node addTwoNumberByLinkedList(Node a, Node b) {
            int carry = 0;
            int sum = 0;
            Node result = null;
            Node pre = null;
            Node temp = null;
            while (a != null || b != null) {
                sum += carry;
                if (a != null) {
                    sum += a.data;
                } else {
                    sum += 0;
                }
                if (b != null) {
                    sum += b.data;
                } else {
                    sum += 0;
                }
                if (sum > 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                sum = sum % 10;
                temp = new Node(sum);
                if (result == null) {
                    result = temp;
                } else {
                    pre.next = temp;
                }
                pre = temp;
                if (a != null) {
                    a = a.next;
                }
                if (b != null) {
                    b = b.next;
                }
            }
            if (carry > 0) {
                temp.next = new Node(carry);
            }

            return result;

        }

        // intersection of the linked list
        public Node getIntersection(Node a, Node b) {
            Node result = null;
            Node n = null;
            while (a != null) {
                int temp = isPresent(b, a.data);
                if (temp == 1) {
                    n.appendToEnd(a.data);
                } else {
                    a = a.next;
                }
            }
            return result;
        }
        //helper function to check if the elements is present in the linkedlist or not for above function

        public int isPresent(Node b, int data) {
            while (b != null) {
                if (b.data == data) {
                    return 1;
                } else {
                    b = b.next;
                }
            }
            return 0;


        }

        // return the node at the start of loop/cycle in circular linkedl list
        public Node getLoopStartNode(Node node) {
            Node slow = node;
            Node fast = node;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            /* Move slow to Head. Keep fast at Meeting Point. Each are k
              steps from the Loop Start. If they move at the same pace,
              they must meet at Loop Start. */
            slow = node;
            while (slow != null) {
                slow = slow.next;
                fast = fast.next;
            }
            // Both now point to the start of the loop
            return fast;
        }

        // Rotate the linked list counter-clockwise by k nodes
        public void rotate(Node node, int k) {
            Node head = node;
            int count = 1;
            while (count < k && node != null) {
                node = node.next;
                count++;
            }
            if (node == null) {
                return;
            }
            Node knode = node;
            while (node.next != null) {
                node = node.next;
            }
            knode.next = head;
            head = knode.next;
            knode.next = null;

        }
        //print /get  middile element in the linked list

        public void getMiddleElement(Node node) {
            Node fast = null;
            Node slow = null;
            if (node != null) {
                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }
            System.out.println("middle element is " + slow);
        }

        // delete the linked list
        public void deleteLinkedList(Node node) {
            Node nxt = null;
            while (node != null) {
                nxt = node.next;
                // free(node); //or use below Garbace collectore
                System.gc();
                node = nxt;
            }
        }

        //fun to get intersection of the two list
        // time complexity O(m+n)
        //where m - no of nodes in list 1 and 
        // n- no of nodes in list2
        public int intersectionOfLists(Node node1, Node node2) {
            int result = 0;
            Hashtable h = new Hashtable();
            while (node1 != null) {
                h.put(true, node1.data);
            }
            while (node2 != null) {
                if (h.containsValue(node2.data)) {
                    System.out.println("intersection is :" + node2.data);
                    result = node2.data;
                } else {
                    System.out.println("no intersection found..");
                }
            }
            return result;
        }
//concate the two linked lists

        public Node concatenateList(Node a, Node b) {
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }

            while (a.next != null) {
                a = a.next;
            }
            a.next = b;
            return a;


        }
 public boolean isPalindrome(Node node) {
     Node fast = node;
     Node slow = node;
     java.util.Stack<Integer> s = new Stack<Integer>();
     while(fast !=null && fast.next != null){
         fast= fast.next.next;
         s.push(slow.data);
         slow =  slow.next;
     }
     //for odd no of elements in the list
     if(fast != null){
         slow = slow.next;
     }
     while(slow != null){
         int top = s.pop();
         if(top != slow.data){
             return false;
         }
         slow = slow.next;
     }
        
     return true;
 }
        //check if linked list is palindrome or not using in built function 
        public boolean isPalindrome2(java.util.LinkedList list) {
            int n = list.size();
            boolean state = false;
            for (int i = 1; i <= n; i++, n--) {
                if (list.get(i) == list.get(n)) {
                    state = true;
                } else {
                    state = false;
                    break;
                }

            }
            return state;
        }
    }
}
