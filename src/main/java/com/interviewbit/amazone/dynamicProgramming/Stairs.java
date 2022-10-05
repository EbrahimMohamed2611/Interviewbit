package com.interviewbit.amazone.dynamicProgramming;

public class Stairs {

    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int prevStair = 1;
        int secondPrevStair = 1;
        int currentStair = 0;
        for (int i = 2; i <= n; i++) {
            currentStair = prevStair + secondPrevStair;
            secondPrevStair = prevStair;
            prevStair = currentStair;
        }
        return currentStair;
    }

}
