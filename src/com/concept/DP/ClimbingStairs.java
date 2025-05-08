package com.concept.DP;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n =3;
        int ways = climbStairs(n);
        System.out.println(ways);
    }

    private static int climbStairs(int n) {
        int [] dp = new int[n+1];
        dp[0] =1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
