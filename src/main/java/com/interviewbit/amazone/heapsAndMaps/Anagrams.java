package com.interviewbit.amazone.heapsAndMaps;

import java.util.*;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> strings) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < strings.size(); i++) {
            char[] chars = strings.get(i).toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(i + 1);
        }
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            result.addAll(Collections.singletonList(entry.getValue()));
        }
        return result;
    }
}
