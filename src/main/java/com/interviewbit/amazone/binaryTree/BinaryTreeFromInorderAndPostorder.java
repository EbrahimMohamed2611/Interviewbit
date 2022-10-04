package com.interviewbit.amazone.binaryTree;

import java.util.*;

public class BinaryTreeFromInorderAndPostorder {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if (inorder == null || postorder == null)
            return null;

        for (int i = 0; i < inorder.size(); i++)
            map.put(inorder.get(i), i);

        return buildTree(0, inorder.size() - 1, inorder, 0, postorder.size() - 1, postorder);
    }

    TreeNode buildTree(int inStart, int inEnd, ArrayList<Integer> inorder, int postStart, int postEnd, ArrayList<Integer> postorder) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootIndex = map.get(postorder.get(postEnd));
        TreeNode root = new TreeNode(postorder.get(postEnd));
        int numsLeft = rootIndex - inStart;

        root.left = buildTree(inStart, rootIndex - 1, inorder, postStart, postStart + numsLeft - 1, postorder);
        root.right = buildTree(rootIndex + 1, inEnd, inorder, postStart + numsLeft, postEnd - 1, postorder);

        return root;

    }
}
