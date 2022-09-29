package com.interviewbit.amazone.arrays;

import java.util.*;

public class FirstMissingInteger {

    // using cycle sort to put every number in the correct position
    public int firstMissingPositive(ArrayList<Integer> arr) {
        /*
        Runtime: 1 ms, faster than 99.96% of Java online submissions for First Missing Positive.
        Memory Usage: 57.8 MB, less than 59.55% of Java online submissions for First Missing Positive.
        */
        int pointer = 0;
        while (pointer < arr.size()) {
            int current = arr.get(pointer);
            if (current > 0 && current <= arr.size() && current != arr.get(arr.get(pointer) -1) )
                swap(arr, pointer, arr.get(pointer) - 1);
            else
                pointer++;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (i+1 != arr.get(i))
                return i + 1;
        }
        return arr.size()+1;

    }


    // Set<Integer> hashSet = new HashSet<>();
    // for(int number : A)
    //     hashSet.add(number);

    // for(int i = 1; i<= A.size()+1; i++)
    //     {
    //         if(!hashSet.contains(i))
    //         return i;
    //     }

    //     return -1;
    private static void swap(ArrayList<Integer> arr, int pointer, int current) {
        int temp = arr.get(current);
        arr.set(current, arr.get(pointer)) ;
        arr.set(pointer, temp);
    }

}

