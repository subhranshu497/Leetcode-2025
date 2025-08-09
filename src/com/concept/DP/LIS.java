package com.concept.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LIS {
    public static void main(String[] args) {
        int [] nums = {7,7,7,7,7,7,7};
        int [][] memo = new int[nums.length+1][nums.length+1];
        for(int [] arr:memo)
            Arrays.fill(arr, -1);
        //int len = lis(nums, 0,-1, memo);
        //using dp
        int len1 = lisDP(nums);
        System.out.println(len1);
    }

    private static int lisDP(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        int lis = Integer.MIN_VALUE;
        Arrays.fill(dp,1); //if only one element is present in the array then it will be the max
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }
        return lis==Integer.MIN_VALUE?1:lis;
    }

    private static int lis(int[] nums, int i, int prev, int [][] memo) {
        //base condition
        if(i>=nums.length)
            return 0;
        int mappedPrev = prev+1;
        if(memo[i][mappedPrev] !=-1)return memo[i][mappedPrev] ;
        //skip
        int skip = lis(nums,i+1, prev, memo);
        int take =0;
        //take the current element

        if(prev==-1 || nums[prev] < nums[i]){
            take = 1+lis(nums, i+1, i, memo);
        }
        return memo[i][mappedPrev] = Math.max(take, skip);
    }
}
