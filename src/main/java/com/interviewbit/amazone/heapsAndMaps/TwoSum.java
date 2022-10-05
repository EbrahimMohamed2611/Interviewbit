package com.interviewbit.amazone.heapsAndMaps;

import java.util.*;

public class TwoSum {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> arr, int target) {
        Map<Integer, Integer> ValueWithindex = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int missing = target - arr.get(i);
            if (ValueWithindex.containsKey(missing)) {
                res.add(ValueWithindex.get(missing));
                res.add(i + 1);
                return res;
            } else if (!ValueWithindex.containsKey(arr.get(i))) {
                // becouse we don't need to put greatre index if we have duplicate
                ValueWithindex.put(arr.get(i), i + 1);
            }
        }
        return res;
    }
}
