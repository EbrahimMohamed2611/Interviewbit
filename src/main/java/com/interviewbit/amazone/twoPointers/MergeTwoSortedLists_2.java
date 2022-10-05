package com.interviewbit.amazone.twoPointers;

import java.util.*;

public class MergeTwoSortedLists_2 {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int firstPointer = 0, secondPointer = 0;
        while (secondPointer < b.size() && firstPointer < a.size()) {
            if (a.get(firstPointer) > b.get(secondPointer)) {
                a.add(firstPointer, b.get(secondPointer++));
            } else {
                firstPointer++;
            }
        }
        while (secondPointer < b.size())
            a.add(b.get(secondPointer++));
    }

}
