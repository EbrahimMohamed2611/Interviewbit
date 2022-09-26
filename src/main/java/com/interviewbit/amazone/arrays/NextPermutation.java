package com.interviewbit.amazone.arrays;

import java.util.*;

public class NextPermutation {

    public static List<Integer> nextPermutation(List<Integer> permutation) {

        int i = permutation.size() - 2;
        while (i >= 0 && permutation.get(i) >= permutation.get(i + 1)) i--;

        if (i >= 0) {
            int j = permutation.size() - 1;
            while (permutation.get(j) <= permutation.get(i))
                j--;
            // swap
            int temp = permutation.get(j);
            permutation.set(j, permutation.get(i));
            permutation.set(i, temp);
        }

        int firstPointer = i + 1;
        int secondPointer = permutation.size() - 1;
        while (firstPointer <= secondPointer) {
            int temp2 = permutation.get(firstPointer);
            permutation.set(firstPointer++, permutation.get(secondPointer));
            permutation.set(secondPointer--, temp2);
        }
        return permutation;
    }

    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        System.out.println(nextPermutation(objects)); // 1, 3, 2
        System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(3, 2, 1)))); // 1, 2, 3
    }
}
