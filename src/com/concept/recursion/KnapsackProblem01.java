package com.concept.recursion;

import java.util.Arrays;

public class KnapsackProblem01 {
    public static void main(String[] args) {
        int W = 4;
        int profit[] = {1, 2, 3},  weight[] = {4, 5, 1};
        int res = ZeroOneKnapsack(W, profit, weight);
        System.out.println(res);
    }

    private static int ZeroOneKnapsack(int w, int[] profit, int[] weight) {
        int n = profit.length;
        int [][] memo = new int[n+1][w+1];
        for(int [] arr:memo)
            Arrays.fill(arr, -1);
        int res = solveKnapsack(w, weight, profit, n,0, memo);
       return res;
    }

    private static int solveKnapsack(int w, int[] weight, int[] profit, int n, int i, int [][] memo) {
        //base condition
        if(i>=n || w<=0){
            return 0;
        }
        if(memo[i][w] !=-1) return memo[i][w];
        //skip
        int skip = solveKnapsack(w, weight, profit, n,i+1, memo);
        //take
        int take = 0;
        if(weight[i]<=w)
            take = profit[i]+solveKnapsack(w-weight[i], weight,profit,n,i+1, memo);

        return memo[i][w]=Math.max(skip, take);

    }

}
