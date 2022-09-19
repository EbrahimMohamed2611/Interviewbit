package com.interviewbit.amazone.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedLists_2 {


    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
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


    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 5, 8));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(6, 9));
        merge(integers, second);
        System.out.println(integers); // 1 5 6 8 9
    }


}
