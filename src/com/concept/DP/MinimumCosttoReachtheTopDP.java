package com.concept.DP;

public class MinimumCosttoReachtheTopDP {
    public static void main(String[] args) {
        int [] costs = {10,15,20};
        int min = minCostDP(costs);
        System.out.println(min);
    }

    private static int minCostDP(int[] costs) {
        int n = costs.length;
        int [] dp = new int[n];
        dp[0] = costs[0];
        dp[1] = costs[1];

        for(int i = 2;i<dp.length;i++){
            dp[i] =costs[i]+Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
