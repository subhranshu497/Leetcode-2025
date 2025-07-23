package com.concept.recursion;

import java.util.Arrays;

public class TheCoinChangeProblem {
    private static int count =0;
    public static void main(String[] args) {
        int n =3;
        int [] coins = {8,3,1,2};
        int ways = collectCoins(n, coins);
        System.out.println(ways);
    }

    //recursion and memoization ,both yeilds TLE
    private static int collectCoins(int n, int[] coins) {
        int  [] memo = new int[coins.length];
        Arrays.fill(memo,-1);
        solveCoinCollect(n, coins,0,0, memo);
        return count;
    }

    private static void solveCoinCollect(int n, int[] coins, int i, int sum, int[] memo) {
        if(sum==n){
            count +=1;
            return;
        }
        if(sum >n || i>=coins.length)return;
        if(memo[i] !=-1){
            count = memo[i];
            return;
        }
        //case for take
        solveCoinCollect(n,coins,i,sum+coins[i], memo);
        //case for skip
        solveCoinCollect(n,coins,i+1,sum, memo);
    }
}
