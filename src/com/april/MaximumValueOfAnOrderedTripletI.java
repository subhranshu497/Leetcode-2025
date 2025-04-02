package com.april;

public class MaximumValueOfAnOrderedTripletI {
    public static void main(String[] args) {
        int [] nums = {12,6,1,2,7};
        long res = maximumTripletValue(nums);
        System.out.println(res);
    }

    private static long maximumTripletValue(int[] nums) {
        long maxDiff =0;
        long result =0;
        long maxI = 0;
        for(int k=0;k<nums.length;k++){
            result = Math.max(result, (maxDiff*nums[k]));
            maxDiff = Math.max(maxDiff, maxI - nums[k]);
            maxI = Math.max(maxI, nums[k]);
        }
        return result;
    }
}
