package com.interviewbit.amazone.binarySearch;

public class SquareRootOfInteger {

    public int sqrt(int number) {
        if(number == 0 || number == 1) return number;
        int low = 1, high = number, ans = 1;
        while(high >= low){
            long mid = low + (high - low) / 2;
            if(mid * mid <= number){
                ans = (int)mid;
                low = (int)mid+1;
            }else{
                high = (int)mid-1;
            }

        }
        return ans;
    }
}
