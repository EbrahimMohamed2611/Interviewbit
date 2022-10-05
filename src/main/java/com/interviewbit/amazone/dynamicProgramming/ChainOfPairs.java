package com.interviewbit.amazone.dynamicProgramming;

import java.util.*;

public class ChainOfPairs {
    // Apply The Longest Increasing Subsequences DP
    public int solve(int[][] pairs) {
        Map<String, Integer> map = new HashMap<>();
        if (pairs.length == 0) return 0;
        return findMaxSequence(-1, 0, pairs, map);
    }


    private int findMaxSequence(int prev, int index, int[][] pairs, Map<String, Integer> map) {
        if (index >= pairs.length)
            return 0;
        if (map.get(prev + "" + index) != null)
            return map.get(prev + "" + index);
        int firstLength = 0;
        if (index == -1 || prev < pairs[index][0]) {
            firstLength = 1 + findMaxSequence(pairs[index][1], index + 1, pairs, map);
        }
        int secondLength = findMaxSequence(prev, index + 1, pairs, map);
        int max = Math.max(firstLength, secondLength);
        map.put(prev + "" + index, max);
        return max;
    }
}
