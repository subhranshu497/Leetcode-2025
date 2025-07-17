package com.july;

import java.util.Arrays;

public class FindtheMaximumLengthofValidSubsequenceII {
    public static void main(String[] args) {
        int [] nums = {1,4,2,3,1,4};
        int k = 3;
        int count = maximumLengthI(nums,k);
        System.out.println(count);
    }

    private static int maximumLengthI(int[] nums, int k) {
        int n = nums.length;
        int [][] dp = new int[k][n];
        int res =1;

        for(int [] arr:dp)
            Arrays.fill(arr, 1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int rem = (nums[i]+nums[j])%k;
                dp[rem][i] = Math.max(dp[rem][i], dp[rem][j]+1);
                res = Math.max(dp[rem][i], res);
            }
        }
        return res;
    }
}
