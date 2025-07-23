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
        int len = lis(nums, 0,-1, memo);
        System.out.println(len);
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
