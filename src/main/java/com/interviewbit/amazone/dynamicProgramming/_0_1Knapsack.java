package com.interviewbit.amazone.dynamicProgramming;

import java.util.*;

public class _0_1Knapsack {

 // Time Complexity : O(N * C)
    // Space Complexity: O(N * C)
    public int solve(ArrayList<Integer> values, ArrayList<Integer> weights, int capacity) {
        int[][]dp = new int[values.size()][capacity+1];
        return knapsack(0, values, weights, capacity,dp);
    }
    private int knapsack(int currentIndex, ArrayList<Integer> values, ArrayList<Integer> weights, int capacity,int[][]dp){

        if(currentIndex == values.size()-1) // will reach the last item we can take if fit in the remain capacity
        {
            if(weights.get(currentIndex) <= capacity)
                return values.get(currentIndex);
            else
                return 0;
        }

        if(dp[currentIndex][capacity] != 0)
            return dp[currentIndex][capacity];
        // first ray to take the current item
        int profit1 = 0;
        if(weights.get(currentIndex) <= capacity)
            profit1 = values.get(currentIndex)+ knapsack(currentIndex+1, values, weights, capacity - weights.get(currentIndex),dp);

        // second try not take the current Item
        // the capacity will remain tha same and will move to next item
        int profit2 = knapsack(currentIndex+1, values, weights, capacity, dp);

        return dp[currentIndex][capacity] = Math.max(profit1, profit2);
    }

}

