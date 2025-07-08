package com.concept.recursion;

import java.util.Arrays;

public class ClimbingStairs {
    private static int ways =0;
    public static void main(String[] args) {
        int n = 3;
        ways = countWaysDP(n);
        System.out.println(ways);
    }

    private static int countWaysDP(int n) {
        int [] dp = new int[n+1];
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        dp[0] =0;
        dp[1] =1;
        dp[2] =2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int countWaysMemo(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private static int countWays(int n, int [] memo) {
        //base condition
        if(n==1) {
            return 1;
        }
        if(n==2) return 2;
        if(memo[n] !=-1) return memo[n];
        int ones = countWays(n-1, memo);
        int twos = countWays(n-2, memo);
        return memo[n] = ones+twos;
    }

}
