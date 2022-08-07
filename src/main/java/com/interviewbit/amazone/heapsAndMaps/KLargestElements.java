package com.interviewbit.amazone.heapsAndMaps;

import java.util.*;

public class KLargestElements {
    public ArrayList<Integer> solve(ArrayList<Integer> numbers, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            queue.add(numbers.get(i));

        for (int i = k; i < numbers.size(); i++) {
            if (numbers.get(i) > queue.peek()) {
                queue.poll();
                queue.add(numbers.get(i));
            }
        }
        return new ArrayList<>(queue);
    }
}
