package com.interviewbit.amazone.twoPointers;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesFromUnSortedArray {


    public int removeElement(ArrayList<Integer> arr, int k) {

        int firstPointer = 0;
        for (int secondPointer = 0; secondPointer < arr.size(); secondPointer++) {
            if(arr.get(secondPointer) != k){
                arr.set(firstPointer++ , arr.get(secondPointer));
            }
        }
        return firstPointer;
    }

    public int removeDuplicates2(ArrayList<Integer> a) {
        Set<Integer> set = new TreeSet<>();
        for(int number : a)
            set.add(number);

        int counter = 0;
        for(int n : set){
            if(counter == set.size())
                break;
            a.set(counter++,n);
        }


        return set.size();
    }
}
