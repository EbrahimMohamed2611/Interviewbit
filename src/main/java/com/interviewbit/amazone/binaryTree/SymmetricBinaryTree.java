package com.interviewbit.amazone.binaryTree;

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode root) {
        if (root == null) return 1;
        return isSymmetric(root.left, root.right);
    }

    private int isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null){
            if(left == right)
                return 1;
            else
                return 0;
        }
        if (left.val != right.val) return 0;
        int leftResult =   isSymmetric(left.left, right.right);
        int rightResult = isSymmetric(left.right, right.left);
        if(leftResult == rightResult && leftResult ==1) return 1;
        else return 0;


    }
}
