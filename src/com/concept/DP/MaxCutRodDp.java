package com.concept.DP;

import java.util.Arrays;

public class MaxCutRodDp {
    public static void main(String[] args) {
        int n=4, x =2, y=1,z=1;
        int cut = maxCutDP(n,x,y,z);
        System.out.println(cut);
    }

    private static int maxCutDP(int n, int x, int y, int z) {
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);

        for(int i=1;i<n;i++){
            if (i >= x && dp[i - x] != -1) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }

            if (i >= y && dp[i - y] != -1) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }

            if (i >= z && dp[i - z] != -1) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }

            if (dp[i] == 0) {
                dp[i] = -1;
            }
        }
        if (dp[n] == -1) {
            return 0;
        }
        return dp[n];
    }
}
