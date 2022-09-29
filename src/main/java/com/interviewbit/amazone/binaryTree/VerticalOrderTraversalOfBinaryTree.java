package com.interviewbit.amazone.binaryTree;

import com.sun.source.tree.Tree;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {

    private class Tuple {
        TreeNode node;
        int vertical;
        int level;

        Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    // Leetcode Version to sort every value in the queue
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // root will be in level 0 and vertical 0 (0,0)
        Tuple node = new Tuple(root, 0, 0);
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            if (!map.containsKey(current.vertical))
                map.put(current.vertical, new TreeMap<>());

            if (!map.get(current.vertical).containsKey(current.level))
                map.get(current.vertical).put(current.level, new PriorityQueue<>());

            map.get(current.vertical).get(current.level).add(current.node.val);

            // here we need to push new nodes with new V and L to Queue
            // when go left we need to decrease the vertical value and increase the level value
            if (current.node.left != null)
                queue.offer(new Tuple(current.node.left, current.vertical - 1, current.level + 1));

            // when go left we need to increase the vertical value and increase the level value
            if (current.node.right != null)
                queue.offer(new Tuple(current.node.right, current.vertical + 1, current.level + 1));
        }

        //final step we need to populate the values
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> vertical : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> level : vertical.values()) {
                while (!level.isEmpty())
                    list.get(list.size()-1).add(level.remove());
            }
        }
        return list;
    }

    // InterviewBit Version just sort by vertical number
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal2(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // root will be in level 0 and vertical 0 (0,0)
        Tuple node = new Tuple(root, 0, 0);
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            if (!map.containsKey(current.vertical))
                map.put(current.vertical, new ArrayList<>());

            map.get(current.vertical).add(current.node.val);


            if (current.node.left != null)
                queue.offer(new Tuple(current.node.left, current.vertical - 1, current.level + 1));

            if (current.node.right != null)
                queue.offer(new Tuple(current.node.right, current.vertical + 1, current.level + 1));
        }

        //final step we need to populate the values
        return new ArrayList<>(map.values());
    }
    // InterviewBit Version just sort by vertical number
    public ArrayList<ArrayList<Integer>> verticalOrderTraversalDFS(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // root will be in level 0 and vertical 0 (0,0)
       dfs(root,0,0,map);

        //final step we need to populate the values
        return new ArrayList<>(map.values());
    }

    private void dfs(TreeNode root, int col, int row, Map<Integer, ArrayList<Integer>> map){
        if(root == null) return;

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(root.val);

        dfs(root.left, col-1, row+1, map);
        dfs(root.right, col+1, row+1, map);

    }
    public static void main(String[] args) {
        /*
        		 1
		        / \
	          2    3
                  /
                4
                 \
                  5
         */
        VerticalOrderTraversalOfBinaryTree verticalOrderTraversalOfBinaryTree = new VerticalOrderTraversalOfBinaryTree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.right.left = new TreeNode(4);
        treeNode.right.left.right = new TreeNode(5);
//        treeNode.right.right = new TreeNode(9);
        ArrayList<ArrayList<Integer>> list = verticalOrderTraversalOfBinaryTree.verticalOrderTraversal2(treeNode);
        ArrayList<ArrayList<Integer>> list2 = verticalOrderTraversalOfBinaryTree.verticalOrderTraversalDFS(treeNode);
        System.out.println(list);
        System.out.println(list2);
    }
}
