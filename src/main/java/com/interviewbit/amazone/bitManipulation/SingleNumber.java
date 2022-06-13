package com.interviewbit.amazone.bitManipulation;

import java.util.List;

public class SingleNumber {
    public int singleNumber(final List<Integer> A) {
        int singleOne = 0;
        for(int number: A){
            singleOne = singleOne ^ number;
        }
        return singleOne;
    }
}
