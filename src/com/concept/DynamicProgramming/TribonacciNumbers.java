package com.concept.DynamicProgramming;

import java.util.Arrays;

public class TribonacciNumbers {
    public static void main(String[] args) {
        int n =4;
        int trib = tribonacciI(n);
        System.out.println(trib);
    }

//using DP
    private static int tribonacciI(int n) {
        int [] dp = new int[n+1];
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        dp[0] =0;
        dp[1] =1;
        dp[2] =1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
    }


    //using memo - TLE
    private static int tribonacciIM(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        int res = triboMemo(n, memo);
        return res;
    }

    private static int triboMemo(int n, int[] memo) {
        //base condtion
        if(n==0) memo[0] =0;
        if(n==1) memo[1] =1;
        if(n==2) memo[2] =1;
        if(memo[n] !=-1) return memo[n];

        return triboMemo(n-3, memo)+triboMemo(n-2, memo)+triboMemo(n-1, memo);
    }

    //using recursion - TLE
    private static int tribonacci(int n) {
        //base case
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;

        return tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1);
    }
}
