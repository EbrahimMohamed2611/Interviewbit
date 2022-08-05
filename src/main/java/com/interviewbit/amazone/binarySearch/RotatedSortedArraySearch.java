package com.interviewbit.amazone.binarySearch;
import java.util.*;

public class RotatedSortedArraySearch {
    public int search(final List<Integer> arr, int k) {
        int start = 0;
        int end = arr.size() - 1;
        int mid;
        while (end >= start) {
            mid = start + (end - start) / 2;
            if (arr.get(mid) == k) return mid;

            if (arr.get(mid) >= arr.get(start)) {
                if (arr.get(start) <= k && k <= arr.get(mid))
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {

                if (arr.get(mid) <= k && k <= arr.get(end))
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
