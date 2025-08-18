package com.leetcode150.arrayString;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        int minSoFar = prices[0];
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<minSoFar){
                minSoFar = prices[i];
            }
            profit =Math.max(profit,prices[i]-minSoFar);
        }
        return profit;
    }
}
