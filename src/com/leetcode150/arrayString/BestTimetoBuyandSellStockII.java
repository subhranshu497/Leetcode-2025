package com.leetcode150.arrayString;

import org.w3c.dom.ls.LSOutput;

public class BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        int [] prices = {1,2,3,4,5};
        int profit = maxProfitII(prices);
        System.out.println(profit);
    }

    private static int maxProfitII(int[] prices) {
        int n = prices.length;
        int profit = 0;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1])
                profit +=prices[i]-prices[i-1];
        }
        return profit;
    }
}
