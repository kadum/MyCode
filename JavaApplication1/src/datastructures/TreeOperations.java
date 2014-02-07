/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import datastructures.TreeNode;
import java.util.*;

/**
 *
 * @author Mak
 */
public class TreeOperations {

    public TreeNode mirrorBinaryTree(TreeNode root) {
        if (root != null) {
            mirrorBinaryTree(root.getLeft());
            mirrorBinaryTree(root.getRight());
            //swap
            TreeNode temp = root.getLeft();
            root.setRight(temp);
            root.setLeft(root.getRight());

        }
        return root;
    }

    // sum of all elements in binary tree
    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return (root.getData() + sum(root.getLeft()) + sum(root.getRight()));
        }
    }
    //given a sum,check if there exist a path from root to any of nodes which addition is equal
    //given sum

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        } else {
            int subSum = sum - root.getData();
            return ((hasPathSum(root.getLeft(), subSum)) || (hasPathSum(root.getRight(), subSum)));
        }
    }
/// sum of leaf nodes in tree
    int leavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }
        return (leavesSum(root.right) + leavesSum(root.left));
    }

    //heigh of binary tree
    public int heightBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = heightBinaryTree(root.getLeft());
            int right = heightBinaryTree(root.getRight());
            if (left > right) {
                return left + 1;
            } else {
                return right + 1;
            }
        }
    }
    //diamter of tree is the number of nodes on the longesh path between the two leave 
    // in a tree

    public int diameter(TreeNode root) {
        int left, right = 0;
        if (root == null) {
            return 0;
        }
        left = heightBinaryTree(root.getLeft());
        right = heightBinaryTree(root.getRight());
        int l = diameter(root.getLeft());
        int r = diameter(root.getRight());

        return Math.max(left + right + 1, Math.max(l, r));
    }

    // if Two trees  are same/similar/equivalent/identical/sturcutrally same
    public boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return ((root1.getData() == root2.getData())
                && (isIdentical(root1.getLeft(), root2.getLeft()))
                && (isIdentical(root1.getRight(), root2.getRight())));
    }

    //Deepest node in binary tree
    public TreeNode deepestNode(TreeNode root) {
        java.util.Queue<TreeNode> q = null;
        if (root == null) {
            System.out.println("error");
        }
        q.add(root);
        while (!q.isEmpty()) {
            q.remove(root);
            if (root.getLeft() != null) {
                q.add(root.getLeft());
            }
            if (root.getRight() != null) {
                q.add(root.getRight());
            }
        }
        return root;
    }
//count the leaf nodes

    public int countLeafNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        java.util.Queue<TreeNode> q = null;
        q.add(root);
        while (q.isEmpty()) {
            q.remove(root);
            //for full nodes reverse the below condition
            if (root.getLeft() == null && root.getRight() == null) {
                count++;
            }
            if (root.getLeft() != null) {
                q.add(root.getLeft());
            }
            if (root.getRight() != null) {
                q.add(root.getRight());
            }
        }
        return count;


    }

    //preorder traversal recursive
    public void preorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    // preorder traversal non-recursive
    public void nonRecursivePreorder(TreeNode root) {
        if (root == null) {
            System.out.println("error");
        }
        Stack s = new Stack();
        while (true) {
            while (root != null) {
                System.out.println(root.getData());
                s.push(root.getData());
                root = root.getLeft();
            }
            if (s.isEmpty()) {
                break;
            }
            root = (TreeNode) s.pop();
            root = root.getRight();
        }

    }
    //Recursive inorder

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.println(root.getData());
            inorder(root.getRight());
        }
    }

    // NON-Recursive inorder using stack
    public void nonRecursiveInorder(TreeNode root) {
        Stack s = new Stack();
        if (root == null) {
            System.out.println("error");
        }
        while (true) {
            while (root != null) {
                s.push(root.getData());
                root = root.getLeft();
            }
            if (s.isEmpty()) {
                break;
            }

            root = (TreeNode) s.pop();
            System.out.println(root.getData());
            root = root.getRight();

        }
    }

    /*
     leverwise traversal
     public void levelTraversal(TreeNode root) {
     Queue q = new Queue(20);
     QueueUsingLinkedList q1 = new QueueUsingLinkedList();
     if (root == null) {
     System.out.println("error");
     }
     TreeNode temp;
     q1.enQueue(root.getData());
     while (q1.isEmpty()) {
     //     TreeNode temp = q1.deQueue();
     System.out.println(temp);
     if(temp.getLeft().equals(true)){
     q1.enQueue(root.getLeft());
     }
     if(temp.getRight().equals(true)){
     q1.enQueue(root.getRight());
     }
     }
     q.deleteQueue();

     }
     */
    //Maximum element in the binary tree
    // for non-recursive approach we can use queue for below function
    public int findMax(TreeNode root) {
        int result = 0;
        if (root != null) {
            int root_val = root.getData();
            int leftVal = findMax(root.getLeft());
            int rightVal = findMax(root.getRight());
            if (leftVal > rightVal) {
                result = leftVal;
            }
            if (rightVal > leftVal) {
                result = rightVal;
            }
            if (root_val > result) {
                result = root_val;
            }
        }
        return result;
    }

    // search given element in binary tree
    // for non- recursive approach, we can use queue
    public boolean SeachElementinTree(TreeNode root, int data) {
        if (root == null) {
            return false;
        } else {
            if (root.getData() == data) {
                return true;
            }
            boolean left = SeachElementinTree(root.getLeft(), data);
            if (left == true) {
                return true;
            } else {
                return (SeachElementinTree(root.getRight(), data));
            }
        }
    }

    //size is the total no of descendants in tree
    public int sizeOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (sizeOfBinaryTree(root.getLeft()) + 1 + sizeOfBinaryTree(root.getRight()));
    }

    //nono recursive to find the size of binary tree
    public int sizeNonRecursiveBinaryTree(TreeNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        java.util.Queue<TreeNode> q = null;
        q.add(root);
        while (!q.isEmpty()) {
            q.remove(root.getData());
            count++;
            if (root.getLeft() != null) {
                q.add(root.getLeft());
            }
            if (root.getRight() != null) {
                q.add(root.getRight());
            }

        }
        q.clear();
        return count;
    }

    // delete recursive 
    public void deleteRecursiveBinaryTree(TreeNode root) {
        if (root == null) {
            System.out.println("error");
        }
        //delete the left and right subtrees
        deleteRecursiveBinaryTree(root.getLeft());
        deleteRecursiveBinaryTree(root.getRight());
        root = null; //java Garbage collector takes care of this

    }

    public void insertElementBinaryTree(TreeNode root, int data) {
        java.util.Queue<Integer> q = null;
        TreeNode newNode = null;
        if (root == null) {
            newNode = new TreeNode(data);
        }
        //TreeNode temp=null;
        int temp = 0;
        q.add(root.getData());
        while (q.isEmpty()) {
            q.remove(root.getData());
            if (root.getLeft() != null) {
                q.add(root.getLeft().getData());
            } else {
                root.getLeft().setLeft(newNode);
                q.clear();
            }
            if (root.getRight() != null) {
                q.add(root.getRight().getData());
            } else {
                root.getRight().setRight(newNode);
            }
        }
        q.clear();
    }
}