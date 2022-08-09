package com.interviewbit.amazone.backtracking;

import java.util.*;

public class SubSet {
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        findAllSubSets(allSubsets, new ArrayList<Integer>(), A, 0);
        allSubsets.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> first, ArrayList<Integer> second) {
                int comp = 0;
                for (int i = 0; i < Math.min(first.size(), second.size()); i++) {
                    comp = Integer.compare(first.get(i), second.get(i));
                    if (comp != 0) {
                        return comp;
                    }
                }
                return Integer.compare(first.size(), second.size());
            }
        });
        return allSubsets;
    }

    private static void findAllSubSets(ArrayList<ArrayList<Integer>> allSubsets,
                                       ArrayList<Integer> added, ArrayList<Integer> elements, int index) {
        if (index == elements.size()) {
            ArrayList<Integer> subSet = new ArrayList<>(added);
            Collections.sort(subSet);
            allSubsets.add(subSet);
            return;
        }

        // First will peek the current elements
        added.add(elements.get(index));
        findAllSubSets(allSubsets, added, elements, index + 1);
        // then will not peak it
        added.remove(elements.get(index));
        findAllSubSets(allSubsets, added, elements, index + 1);
    }




    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        System.out.println(subsets(numbers));
    }
}
