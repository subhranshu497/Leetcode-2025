package com.concept.DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n =4;
        int fib = fiboMemo(n);
        System.out.println();
    }

    //using recursion
    private static int fibo(int n) {
        //base case
        if(n==0) return 0;
        if(n==1) return 1;

        return fibo(n-1)+fibo(n-2);
    }
    private static int fiboMemo(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        int fib = fibSolve(n, memo);
        return fib;
    }

    private static int fibSolve(int n, int[] memo) {
        //base case
        if(n==0) return 0;
        if(n==1) return  1;

        if(memo[n] !=-1) return memo[n];

        return fibSolve(n-1, memo)+fibSolve(n-2, memo);
    }

    private static int fiboDp(int n) {
        int [] dp = new int[n+1];
        //intialize with the base condition values
        dp[0] =0;
        dp[1] =1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
