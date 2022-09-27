package com.interviewbit.amazone.arrays;

import java.util.*;

public class RepeatAndMissingNumberArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int[] frequencyArray = new int[A.size()+1];
        ArrayList<Integer> missingAndRepeating = new ArrayList<Integer>();
        for(int number : A){
            frequencyArray[number]++;
            if(frequencyArray[number] == 2)
                missingAndRepeating.add(number);
        }


        for(int i = 1; i<= frequencyArray.length; i++){
            if(frequencyArray[i] == 0){
                missingAndRepeating.add(i);
                break;
            }
        }

        return missingAndRepeating;
    }
}
