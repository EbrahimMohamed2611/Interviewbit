package com.interviewbit.amazone.graph;

import java.util.*;

public class PossibilityOfFinishingAllCoursesGivenPreRequisites {

    public int solve(int n, ArrayList<Integer> B, ArrayList<Integer> C) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; ++i)
            adjacencyList.add(i, new ArrayList<>());

        buildAdjacencyList(adjacencyList, B, C);
        boolean[] visited = new boolean[n + 1];
        boolean[] visiting = new boolean[n + 1];
        for (int node = 1; node <= n; node++) {
            if (!visited[node]) {
                if (isGraphContainCycle(node, adjacencyList, visited, visiting))
                    return 0;
            }
        }
        return 1;
    }

    private static boolean isGraphContainCycle(int node, List<List<Integer>> adjacencyList, boolean[] visited, boolean[] visiting) {
        visited[node] = true;
        visiting[node] = true;
        for (int neighbour : adjacencyList.get(node)) {
            if (!visited[neighbour]) {
                if (isGraphContainCycle(neighbour, adjacencyList, visited, visiting))
                    return true;
            } else if (visiting[neighbour])
                return true;
        }
        visiting[node] = false;
        return false;
    }

    private static void buildAdjacencyList(List<List<Integer>> adjacencyList, ArrayList<Integer> B, ArrayList<Integer> C) {
        for (int i = 0; i < B.size(); i++) {
            adjacencyList.get(B.get(i)).add(C.get(i));
        }
    }
}
