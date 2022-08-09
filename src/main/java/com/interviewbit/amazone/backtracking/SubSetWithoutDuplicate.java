package com.interviewbit.amazone.backtracking;

import java.util.*;

public class SubSetWithoutDuplicate {

    public static ArrayList<ArrayList<Integer>> subsetsWithoutDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        findAllSubSets(allSubsets, new ArrayList<Integer>(), A, 0);
        return allSubsets;
    }

    private static void findAllSubSets(ArrayList<ArrayList<Integer>> allSubsets, ArrayList<Integer> subSet, ArrayList<Integer> a, int index) {
        allSubsets.add(new ArrayList<>(subSet));
        for (int j = index; j < a.size(); j++) {
            if (j != index && a.get(j).equals(a.get(j - 1))) continue; // To avoid duplicate
            // Take
            subSet.add(a.get(j));
            findAllSubSets(allSubsets, subSet, a, j+1);
            // Then not take
            subSet.remove(subSet.size() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        System.out.println(subsetsWithoutDup(numbers));
        /*
        [
        [],
        [1],
        [1,2],
        [1,2,2],
        [2],
        [2, 2]
        ]
         */
    }
}
