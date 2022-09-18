package com.interviewbit.amazone.twoPointers;

import java.util.*;

public class PairWithGivenDifference {


    public static int solve2(List<Integer> arr, int number) {
        Map<Integer, Integer> numberWithFrequency = new HashMap<>();

        for (int num : arr) {
            numberWithFrequency.put(num, numberWithFrequency.getOrDefault(num, 0) + 1);
            if (number == 0 && numberWithFrequency.get(num) > 1)
                return 1;
        }
        if(number == 0) return 0;
        for (int num : arr)
            if (numberWithFrequency.containsKey(number + num)) return 1;


        return 0;
    }

    public int solve(ArrayList<Integer> arr, int number) {
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            int target = arr.get(i) - number;
            int index = search(arr, target);
            if (search(arr, target) != -1 && index != i) {
                return 1;
            }
        }
        return 0;
    }

    private int search(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr.get(mid) == target)
                return mid;
            else if (arr.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solve2(Arrays.asList(5, 10, 3, 2, 50, 80), 78)); // 1
        System.out.println(solve2(Arrays.asList(-10, 20), 30)); // 1
        System.out.println(solve2(Arrays.asList(-10, 20), 30)); // 1
        System.out.println(solve2(Arrays.asList(90, 70, 20, 80, 50), 45)); // 0
        System.out.println(solve2(Arrays.asList(-515, 93, -657, -477, 587, 314, 503, 448, 200, 458, -382, -420, 796, -202, 281, 589, -202, -991, 157, -528, 622, -462,
                        -708, -962, -821, -810, 657, 958, -809, 815, -112, 156, 511, -798, -366, -728, -945, -672, -354, -638, -114, -125, -567, 869, -858, 844),
                -78119)); // 0
    }

}
