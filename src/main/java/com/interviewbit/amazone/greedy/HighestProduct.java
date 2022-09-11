package com.interviewbit.amazone.greedy;

import java.util.Arrays;

public class HighestProduct {

    public int maxp3(int[] nums) {
        Arrays.sort(nums);
        int firstTwoAndTheLast = nums[0] * nums[1] * nums[nums.length-1];
        int lastThreeElements = nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1];
        return Math.max(firstTwoAndTheLast, lastThreeElements);
    }

}
