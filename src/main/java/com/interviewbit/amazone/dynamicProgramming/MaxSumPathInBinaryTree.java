package com.interviewbit.amazone.dynamicProgramming;

import com.interviewbit.amazone.binaryTree.TreeNode;

public class MaxSumPathInBinaryTree {

    public int maxPathSum(TreeNode root) {
        int[] maxPathSum = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, maxPathSum);
        return maxPathSum[0] ;
    }

    private int maxPathSumHelper(TreeNode root, int[] maxPathSum){
        if(root == null)
            return 0;

        int leftPath = Math.max(maxPathSumHelper(root.left, maxPathSum),0);
        int rightPath = Math.max(maxPathSumHelper(root.right, maxPathSum),0);

        maxPathSum[0] = Math.max(maxPathSum[0],leftPath+rightPath+root.val);
        return root.val + Math.max(leftPath, rightPath);
    }
}
