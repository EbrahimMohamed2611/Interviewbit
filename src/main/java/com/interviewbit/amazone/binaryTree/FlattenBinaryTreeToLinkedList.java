package com.interviewbit.amazone.binaryTree;

public class FlattenBinaryTreeToLinkedList {

    TreeNode prev;
    public TreeNode flatten2(TreeNode root) {
        helper(root);
        return root;
    }
    private void helper(TreeNode root) {
        if (root == null)
            return ;

        helper(root.right);
        helper(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }


    // Another way
    public TreeNode flatten(TreeNode root) {
        return helper(root, null);
    }
    // helper function takes in the previous head, do the flattening and returns the head of to flatten binary tree
    private TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return prev;
        }
        prev = helper(root.right, prev);
        prev = helper(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root; // also, we can remove this line because it is not used anymore in this call stack
        return root;
    }
}