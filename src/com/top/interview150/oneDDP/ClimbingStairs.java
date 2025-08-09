package com.top.interview150.oneDDP;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        int ways = climbStairsInterview150(n);
        System.out.println(ways);
    }

    private static int climbStairsInterview150(int n) {
        if(n==1 || n==2)return n;
        int [] dp = new int [n+1];
        dp[0] =0;
        dp[1] =1;
        dp[2] =2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
