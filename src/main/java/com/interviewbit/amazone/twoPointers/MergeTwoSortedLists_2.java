package com.interviewbit.amazone.twoPointers;

import java.util.*;

public class MergeTwoSortedLists_2 {
    // This Solution
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int midPointer = m-1;
        int lastPointer = n-1;
        int insertPosition = nums1.length -1;
        while(lastPointer >= 0){
            if(midPointer >= 0 && nums1[midPointer] > nums2[lastPointer]){
                nums1[insertPosition--] = nums1[midPointer--] ;
            }else{
                nums1[insertPosition--] =  nums2 [lastPointer--] ;
            }
        }
    }

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
