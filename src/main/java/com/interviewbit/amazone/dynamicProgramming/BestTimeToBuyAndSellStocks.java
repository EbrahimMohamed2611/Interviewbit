package com.interviewbit.amazone.dynamicProgramming;

import java.util.*;

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(final List<Integer> price) {
        if(price.size() == 0 ) return 0;
        int currentMinPrice = price.get(0);
        int maxProfit = 0; // the worst case will buy and sell in the same day
        for(int i =1; i< price.size();i++){
            int currentCost = price.get(i) - currentMinPrice;
            maxProfit = Math.max(currentCost, maxProfit);
            // keep the min price until now
            currentMinPrice = Math.min(currentMinPrice, price.get(i));
        }

        return maxProfit;
    }
}
