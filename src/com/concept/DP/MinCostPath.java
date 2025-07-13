package com.concept.DP;

import java.util.Arrays;

public class MinCostPath {
    private static int [][] directions ={{0,1},{1,0},{1,1}};
    public static void main(String[] args) {
        int [][] cost = {{1,2,3},{4,8,2},{1,5,3}};
        int minVal = minCostFinderDP(cost);
        System.out.println(minVal);
    }

    private static int minCostFinderDP(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;
        int [][] dp = new int[m+1][n+1];
        //fill the first row and column with maxval
        for(int [] arr:dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int val = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])));
                dp[i][j] = cost[i-1][j-1]+
                        (val==Integer.MAX_VALUE?0:val);
            }
        }
        return dp[m][n];
    }

    private static int minCostFinder(int[][] cost) {
        int m = cost.length;
        int n = cost[0].length;
        int [][] memo = new int[m+1][n+1];
        for(int [] arr:memo){
            Arrays.fill(arr, -1);
        }
        int minCost = minCostFinderRecursion(cost, m,n,0,0, memo);
        return minCost;
    }

    private static int minCostFinderRecursion(int[][] cost, int m, int n, int i, int j, int [][] memo) {
        //check out of bound case
        if(i>=m || j>=n)return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1)return cost[i][j];
        if(memo[i][j] != -1) return memo[i][j];
        return memo[i][j]=cost[i][j]+Math.min(minCostFinderRecursion(cost,m,n,i,j+1, memo),Math.min(
                minCostFinderRecursion(cost,m,n,i+1,j, memo),
                minCostFinderRecursion(cost,m,n,i+1,j+1, memo)));

    }
}
