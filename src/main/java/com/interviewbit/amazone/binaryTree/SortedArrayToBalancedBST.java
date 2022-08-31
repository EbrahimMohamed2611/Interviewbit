package com.interviewbit.amazone.binaryTree;

public class SortedArrayToBalancedBST {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public TreeNode sortedArrayToBST(final int[] nums) {
        // start   end
        return buildBST(0,nums.length-1, nums);
    }

    private TreeNode buildBST(int start, int end, int[] nums){
        if(end < start)
            return null;

        int mid = (end + start) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(start, mid-1, nums);
        root.right = buildBST(mid+1, end, nums);

        return root;

    }
}
