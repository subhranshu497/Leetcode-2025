package com.concept.DP;

public class CoinProblemDP {
    public static void main(String[] args) {
        int n =3;
        int [] coins = {8,3,1,2};
        long ways = collectCoinsDP(n, coins);
        System.out.println(ways);
    }

    private static long collectCoinsDP(int n, int[] coins) {
        long [][] dp = new long[coins.length+1][n+1];
        //there is one way to make sum =0
        for(int i=0;i<=coins.length;i++)
            dp[i][0] = 1;
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=n;j++){ // it is for sum
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[coins.length][n];
    }
}
