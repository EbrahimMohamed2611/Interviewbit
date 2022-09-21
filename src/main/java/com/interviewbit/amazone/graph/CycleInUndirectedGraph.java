package com.interviewbit.amazone.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleInUndirectedGraph {

    public int solve(int nodes, ArrayList<ArrayList<Integer>> adjacencyList) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        buildAdjacencyList(adjacencyList, nodes, adjList);

        boolean[] visited = new boolean[nodes + 1];
        for (int i = 0; i <= nodes; i++) { // to ensure you will traverse all components
            if (!visited[i]) {
                if (isCycle(i, visited, adjList))
                    return 1;
            }
        }
        return 0;
    }

    private static boolean isCycle(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adjacencyList) {
        visited[i] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, -1}); // pairs<currentNode, previous>
        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int node = currentNode[0];
            int prev = currentNode[1];
            for (int neighbour : adjacencyList.get(node)) {
                if (!visited[neighbour]) {
                    queue.add(new int[]{neighbour, node});
                    visited[neighbour] = true;
                } else if (prev != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void buildAdjacencyList(ArrayList<ArrayList<Integer>> adjacencyMatrix, int V, ArrayList<ArrayList<Integer>> adjList) {
        for (int i = 0; i <= V; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (ArrayList<Integer> cell : adjacencyMatrix) {
            adjList.get(cell.get(0)).add(cell.get(1));
            adjList.get(cell.get(1)).add(cell.get(0));
        }
    }
}