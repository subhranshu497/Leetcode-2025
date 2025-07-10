package com.concept.DP;

public class MinimumperfectsquaresDP {
    public static void main(String[] args) {
        int n =6;
        int res = minSqr(n);
        System.out.println(res);
    }

    private static int minSqr(int n) {
        int [] dp = new int[n];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] =i;
            for(int j=1;j*j<=i;j++){
                dp[i] =Math.min(dp[i], 1+dp[n-(j*j)]);
            }
        }
        return dp[n];
    }
}
