package com.oct;

import java.util.Arrays;

public class MinimumSubarraysinaValidSplit {
    public static void main(String[] args) {
        int [] nums = {2,6,3,4,3};
        int split = validSubarraySplit(nums);
        System.out.println(split);
    }

    private static int validSubarraySplit(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        int split = validiSubArrSplitdp(nums, 0, n, dp);
        return split==Integer.MAX_VALUE?-1:split;
    }

    private static int validiSubArrSplitdp(int[] nums, int i, int n, int[] dp) {
        //base condition
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int min = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            if(gcd(nums[i], nums[j])>1) {
                int split = validiSubArrSplitdp(nums, j + 1, n, dp);
                if(split != Integer.MAX_VALUE)
                    min = Math.min(min, split+1);
            }
        }
        return dp[i] = min;
    }

    private static int gcd(int num1, int num2) {
        if(num2==0) return num1;
        return gcd(num2, num1 % num2);
    }
}
