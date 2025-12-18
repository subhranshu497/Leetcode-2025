package com.dec;

import com.may.LoggerRateLimiter;

import java.util.Arrays;

public class BestTimetoBuyandSellStockV {
    public static void main(String[] args) {
        int [] prices = {1,7,9,8,2};
        int k =2;
        long profit = maximumProfit(prices,k);
        System.out.println(profit);
    }

    private static long maximumProfit(int[] prices, int k) {
        //3 cases
        //buy - sell = case 1 - as first buy so -prices[i]
        //sell - buy = case 2 - as first sell so +prices[i]
        //if buy then sell and vice verse case 0
        int n = prices.length;
        long dp [][][] = new long[n][k+1][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                for(int l=0;l<3;l++){
                    dp[i][j][l] = Long.MIN_VALUE;
                }
            }
        }
        long profit = solveMaximumProfit(prices,k, n, 0, 0, dp);
        return profit;
    }

    private static long solveMaximumProfit(int[] prices, int k, int n, int i, int cases, long [][][] dp) {
        //base condition
        if(i ==n){
            if(cases==0) return 0;
            return Long.MIN_VALUE/2;
        }
        long take =Long.MIN_VALUE;
        if(dp[i][k][cases] != Long.MIN_VALUE)
            return dp[i][k][cases];
        //dontTake
        long skip = solveMaximumProfit(prices,k, n,i+1,cases, dp);
        if(k>0){
            if(cases==1){
                take = -prices[i]+solveMaximumProfit(prices,k-1,n,i+1,0, dp);
            }else if(cases == 2){
                take = prices[i]+solveMaximumProfit(prices,k-1,n,i+1,0, dp);
            }else {
                take = Math.max(-prices[i]+solveMaximumProfit(prices,k,n,i+1,2, dp),
                        prices[i]+solveMaximumProfit(prices,k,n,i+1,1, dp));
            }
        }
        return dp[i][k][cases] = Math.max(skip, take);
    }
}
