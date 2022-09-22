package com.interviewbit.amazone.graph;

import java.util.*;

public class CycleInDirectedGraph {

    public static int solve(int numberOnNodes, ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        buildAdjacencyList(adjacencyList, numberOnNodes, matrix);
        boolean[] visited = new boolean[numberOnNodes + 1];
        boolean[] pathVisited = new boolean[numberOnNodes + 1];
        for (int i = 1; i <= numberOnNodes; i++) { // for Multiple Components
            if (!visited[i])
                if (isGraphHaveCycle(i, visited, pathVisited, adjacencyList))
                    return 1;
        }
        return 0;
    }

    private static boolean isGraphHaveCycle(int node, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adjacencyList) {
        visited[node] = pathVisited[node] = true;

        for (int neighbour : adjacencyList.get(node)) {
            if (!visited[neighbour]) {
                if (isGraphHaveCycle(neighbour, visited, pathVisited, adjacencyList))
                    return true;
            } else if (pathVisited[neighbour])
                return true;
        }
        pathVisited[node] = false;
        return false;
    }

    private static void buildAdjacencyList(ArrayList<ArrayList<Integer>> adjacencyList, int numberOnNodes, ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i <= numberOnNodes; i++)
            adjacencyList.add(i, new ArrayList<>());

        for (List<Integer> list : matrix) {
            adjacencyList.get(list.get(0)).add(list.get(1));
        }
    }

    public static void main(String[] args) {
//    List<List<Integer>> list = new ArrayList<>();
//    list.add(Arrays.asList(1,2));
//    list.add(Arrays.asList(4,1));
//    list.add(Arrays.asList(2,4));
//    list.add(Arrays.asList(3,4));
//    list.add(Arrays.asList(5,2));
//    list.add(Arrays.asList(1,3));
//        System.out.println(solve(5, l));
    }
}
