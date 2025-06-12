package com.concept.DynamicProgramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        int steps = climb(n);
        System.out.println(steps);
    }

    private static int climb(int n) {
        int [] dp = new int[n+1];
        dp[1] =1;
        dp[2] = 2;
        if(n==1 || n==2)return dp[n];

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
