package com.interviewbit.amazone.twoPointers;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {


    public int removeDuplicates(ArrayList<Integer> a) {
        if(a.size() == 1)
            return 1;
        int insertPosition = 0;
        for(int i = 1; i< a.size(); i++){
            if(a.get(insertPosition) < a.get(i)){
                insertPosition++;
                a.set(insertPosition, a.get(i));
            }
        }
        return insertPosition+1;
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
