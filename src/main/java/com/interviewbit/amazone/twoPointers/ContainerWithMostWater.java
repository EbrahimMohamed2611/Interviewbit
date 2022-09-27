package com.interviewbit.amazone.twoPointers;

import java.util.*;

public class ContainerWithMostWater {


    // Time: O(n)
    // Space: O(1)
    public int maxArea(ArrayList<Integer> height) {
        int left = 0, right = height.size()-1;
        int maxArea = 0;
        while(right > left){
            int currentArea = Math.min(height.get(left), height.get(right)) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if(height.get(left) < height.get(right))
                left++;
            else
                right--;
        }
        return maxArea;
    }

    // Using BruteForce
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int i = 0; i< height.length; i++){
            for(int j = i; j < height.length; j++){
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j -i));
            }
        }
        return maxArea;

    }

}
