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

    public static int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
