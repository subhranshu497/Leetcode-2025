package com.concept.recursion;

import java.util.Map;
import java.util.PriorityQueue;

public class MaximumBalancedSubsequenceSum {
    public static void main(String[] args) {
        int [] nums = {3,3,5,6};
        long sum = maxBalancedSubsequenceSum(nums);
        System.out.println(sum);
    }

    private static long maxBalancedSubsequenceSum(int[] nums) {
        int prevIdx = -1;
        int max = Integer.MIN_VALUE;
        for(int num:nums)
            max = Math.max(max, num);
        if(max <=0)
            return max;
        long sum = maxBalSubSum(nums, prevIdx, 0);
        return sum;
    }

    private static long maxBalSubSum(int[] nums, int prevIdx, int currIdx) {
        //base condition
        if(currIdx >=nums.length){
            return 0;
        }
        //take
        long take = 0;
        if(prevIdx==-1 || (nums[currIdx]-currIdx) >=(nums[prevIdx]-prevIdx)){
            take = nums[currIdx]+maxBalSubSum(nums, currIdx, currIdx+1);
        }
        long skip = maxBalSubSum(nums,prevIdx, currIdx+1);
        return Math.max(take, skip);
    }
}
