package com.interviewbit.amazone.binaryTree;

public class LeastCommonAncestor {
    public int lca(TreeNode A, int B, int C) {
        boolean[] areExist = new boolean[2];
        TreeNode result = lowestCommonAncestor(A, new TreeNode(B), new TreeNode(C), areExist);
        if(!areExist[0] || !areExist[1]) return -1;
        return result.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, boolean[] areExist) {
        if (root == null)
            return null;


        TreeNode left = lowestCommonAncestor(root.left, p, q, areExist);
        TreeNode right = lowestCommonAncestor(root.right, p, q, areExist);

        if (root.val == p.val || root.val == q.val) {
            if (root.val == p.val) areExist[0] = true;
            if (root.val == q.val) areExist[1] = true;
            return root;
        }
        if(left != null && right != null)
            return root;
        else if(left == null && right != null)
            return right;
        else
            return left;

    }
}
