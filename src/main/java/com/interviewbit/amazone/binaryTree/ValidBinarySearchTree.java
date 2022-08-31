package com.interviewbit.amazone.binaryTree;

public class ValidBinarySearchTree {
    public int isValidBST(TreeNode root) {
        return isBinarySearchTreeHelper(root, Long.MIN_VALUE, Long.MAX_VALUE)? 1:0;
    }
    private boolean isBinarySearchTreeHelper(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (!(root.val > minValue && root.val < maxValue))
            return false;

        return (isBinarySearchTreeHelper(root.left, minValue, root.val)
                && isBinarySearchTreeHelper(root.right, root.val, maxValue));

    }
}
