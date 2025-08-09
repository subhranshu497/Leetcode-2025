package com.concept.DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxLengthOfPairChain {
    public static void main(String[] args) {
        int [][] pairs = {{1,2},{7,8},{4,5}};
        int len = findLongestChainDP(pairs);
        System.out.println(len);
    }

    private static int findLongestChainDP(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->a[0]-b[0]);
        int n = pairs.length;
        int [] dp = new int[n+1];
        int len = Integer.MIN_VALUE;
        Arrays.fill(dp, 1); // minimum length is 1
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    len = Math.max(len, dp[i]);
                }
            }
        }
        return len==Integer.MIN_VALUE?1:len;
    }
}
