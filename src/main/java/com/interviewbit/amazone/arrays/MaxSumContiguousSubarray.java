package com.interviewbit.amazone.arrays;

import java.util.*;

public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> arr) {
        int currentSum, currentMax;
        currentMax = currentSum = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            currentSum = Math.max(arr.get(i), arr.get(i) + currentSum);
            if (currentSum > currentMax)
                currentMax = currentSum;
        }
        return currentMax;
    }
}
