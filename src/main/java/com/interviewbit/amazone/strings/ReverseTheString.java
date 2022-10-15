package com.interviewbit.amazone.strings;

public class ReverseTheString {
    public static String solve(String string) {
        String[] strings = string.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(solve("the sky is blue"));
        System.out.println(solve("this is ib"));
    }
}
