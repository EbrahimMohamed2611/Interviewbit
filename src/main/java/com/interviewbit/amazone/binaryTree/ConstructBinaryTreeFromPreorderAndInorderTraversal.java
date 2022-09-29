package com.interviewbit.amazone.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {


    /*
    Runtime: 2 ms, faster than 99.13% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
Memory Usage: 41.9 MB, less than 93.70% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    */
    Map<Integer, Integer> valueWithIndexMap = new HashMap<>();

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        for (int i = 0; i < inorder.size(); i++)
            valueWithIndexMap.put(inorder.get(i), i);

        return buildTree(0, preorder.size(), preorder, 0, inorder.size() - 1);
    }

    private TreeNode buildTree(int preStart, int preEnd, ArrayList<Integer> preorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder.get(preStart));
        int rootIndexInInorder = valueWithIndexMap.get(root.val);
        int numberOfElementLeftOnRootInInorder = rootIndexInInorder - inStart;

        root.left = buildTree(preStart + 1, preStart + numberOfElementLeftOnRootInInorder, preorder,
                inStart, rootIndexInInorder - 1);

        root.right = buildTree(preStart + numberOfElementLeftOnRootInInorder + 1, preEnd, preorder,
                rootIndexInInorder + 1, inEnd);

        return root;
    }

}
