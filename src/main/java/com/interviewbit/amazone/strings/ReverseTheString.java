package com.interviewbit.amazone.strings;

public class ReverseTheString {
    public static String solve(String string) {
        // string can have more than one space, so we need to neglect all this space, and we need just one space
        String[] strings = string.replaceAll("\\s{2,}"," ").trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = strings.length-1; i>0; i--){
            stringBuilder.append(strings[i]).append(" ");
        }
        stringBuilder.append(strings[0]);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("the sky is blue"));
        System.out.println(solve("this is ib"));
    }
}
