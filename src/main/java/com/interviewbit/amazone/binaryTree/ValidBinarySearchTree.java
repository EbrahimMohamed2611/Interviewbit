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


    // Best Solution
    public boolean isValidBST2(TreeNode root) {
        return isBinarySearchTreeHelper2(root, null, null);
    }
    private boolean isBinarySearchTreeHelper2(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null)
            return true;
        else if (minValue != null && root.val <= minValue || maxValue != null && root.val >= maxValue)
            return false;

        else return (isBinarySearchTreeHelper2(root.left, minValue, root.val)
                    && isBinarySearchTreeHelper2(root.right, root.val, maxValue));

    }
}
