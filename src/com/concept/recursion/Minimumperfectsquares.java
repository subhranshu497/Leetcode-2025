package com.concept.recursion;

import java.util.Arrays;

public class Minimumperfectsquares {
    public static void main(String[] args) {
        int n =4;
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        int count = minSquares(n, memo);
        System.out.println(count);
    }

    private static int minSquares(int n, int[] memo) {
        //base condition
        if(n<=3) return n;
        if(memo[n]!=-1) return memo[n];
        int count =n;
        for(int i=1;i*i<=n;i++){
            count = Math.min(count, 1+minSquares(n-(i*i), memo));
        }
        return memo[n]=count;
    }
}
