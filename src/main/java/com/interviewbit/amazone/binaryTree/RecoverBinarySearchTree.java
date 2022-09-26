package com.interviewbit.amazone.binaryTree;

import java.util.*;

public class RecoverBinarySearchTree {

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
