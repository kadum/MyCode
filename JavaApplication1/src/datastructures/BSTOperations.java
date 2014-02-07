/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import com.sun.org.apache.bcel.internal.generic.FREM;
import datastructures.TreeNode;

/**
 *
 * @author Mak
 */
public class BSTOperations {

    //check if given tree is BST
    public boolean isBST(TreeNode root){
        if(root == null){
            return false;
        }
        //check for left child
       /* if(root.getLeft() !=null && root.getLeft().getData() > root.getData()){
            return false;
        }
        * OR  better version of this is below
        */
        if(root.getLeft() != null &&  findMax(root.getLeft()) > root.getData()){
            return false;
        }
            
        
        //check for right child
       /* if(root.getRight() != null && root.getRight().getData() < root.getData()){
            return false;
        }
        * OR better version of this is below
        */
        
        if(root.getRight() != null && findMin(root.getRight()) < root.getData()){
            return false;
        }
        //recures for left and right child
        if(!isBST(root.getLeft()) || !isBST(root.getRight())){
            return false;
        }
        return true;
            
    }
    // delete in BST
    public TreeNode delete(TreeNode root, int data) {
        if (root == null) {
            System.out.println("no element found");
        }
        if (data > root.getData()) {
            root.setRight(delete(root.getRight(), data));
        }
        if (data < root.getData()) {
            root.setLeft(delete(root.getLeft(), data));
        } else {
            if (root.getLeft() != null && root.getRight() != null) {
                TreeNode temp = null;
                //return type of findMax is int not treenode 
                temp = findMax(root.getLeft());
                root.setData(temp.data);
                root.left = delete(root.getLeft(), root.getData());
            } else {
                TreeNode temp1 = null;
                temp1 = root;
                if (root.getLeft() == null) {
                    root = root.getRight();
                }
                if (root.getRight() == null) {
                    root = root.getLeft();
                }


            }


        }
    }
    //search an element in BST.Non Recursive approach

    public boolean searchInBST(TreeNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.getData() == data) {
            return true;
        } else {
            if (data > root.getData()) {
                root = root.getRight();
            } else {
                root = root.getLeft();
            }
        }
        return false;
    }
//find minimum element in BST

    public int findMin(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.getLeft() == null) {
            return root.getData();
        } else {
            return findMin(root.getLeft());
        }

    }

    //find max element in BST
    public int findMax(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.getRight() == null) {
            return root.getData();
        } else {
            return findMax(root.getRight());
        }
    }

    public TreeNode insertInBST(TreeNode root, int data) {
        if (root == null) {
            System.out.println("error..");
            root = new TreeNode(data);
            root.setLeft(null);
            root.setRight(null);
        } else {
            if (data > root.getData()) {
                root.setRight(insertInBST(root.getRight(), data));
            } else {
                if (data < root.getData()) {
                    root.setLeft(insertInBST(root.getLeft(), data));
                }
            }
        }
        return root;

    }
}
