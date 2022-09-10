package com.interviewbit.amazone.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInArray {

    /*
Runtime: 4 ms, faster than 96.13% of Java online submissions for Find the Duplicate Number.
Memory Usage: 77.9 MB, less than 17.06% of Java online submissions for Find the Duplicate Number.
*/
    public int findDuplicate(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (++freq[nums[i]] > 1)
                return nums[i];
        }
        return -1;
    }

    /*
    Runtime: 17 ms, faster than 38.83% of Java online submissions for Find the Duplicate Number.
    Memory Usage: 60.3 MB, less than 87.81% of Java online submissions for Find the Duplicate Number.
     */
    public int findDuplicate2(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++)
            if (!set.add(A[i]))
                return A[i];
        return -1;
    }


}
