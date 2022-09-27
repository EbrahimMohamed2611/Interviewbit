package com.interviewbit.amazone.binaryTree;

import java.util.*;

public class RecoverBinarySearchTree {
    // Using Morris Inorder Traversal
    // Space: O(1)   Time: O(N)
    private TreeNode firstNode, prevNode, middleNode, lastNode;

    public ArrayList<Integer> recoverTreeUsingMorris(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        TreeNode current = root;
        TreeNode predecessor = null;

        while (current != null) {

            if (current.left == null) {
                // logic here
                if (prevNode != null && prevNode.val > current.val) {
                    if(firstNode == null){
                        firstNode = prevNode;
                        middleNode = current;
                    }
                    lastNode =current;
                }

                prevNode = current;
                current = current.right;
            } else {
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) // Second condition to avoid cycle
                    predecessor = predecessor.right;

                if (predecessor.right == null) {
                    predecessor.right = current; // create link between root and predecessor
                    current = current.left; // then go to left
                } else { // here we need to fix the links
                    predecessor.right = null;
                    // logic should be here
                    if (prevNode != null && prevNode.val > current.val) {
                        if(firstNode == null){
                            firstNode = prevNode;
                            middleNode = current;
                        }
                        lastNode =current;
                    }

                    prevNode = current;
                    current = current.right; // go right because we reach the end of all left subTree
                }
            }
        }

        if(lastNode != null){
            list.add(lastNode.val);
            list.add(firstNode.val);
        }else{
            list.add(middleNode.val);
            list.add(firstNode.val);
        }
            return list;
    }


    private TreeNode first, middle, prev, last;

    public ArrayList<Integer> recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        recoverTreeRecursive(root);
        if (first != null && last != null) {
            list.add(last.val);
            list.add(first.val);
        } else {
            list.add(middle.val);
            list.add(first.val);
        }
        return list;

    }

    private void recoverTreeRecursive(TreeNode root) {
        if (root == null)
            return;

        recoverTreeRecursive(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) { // for the first mistake and also cane be only the mistake
                first = prev;
                middle = root;
            } else {
                last = root; // when we see the second mistake
            }
        }

        prev = root;
        recoverTreeRecursive(root.right);
    }

}
