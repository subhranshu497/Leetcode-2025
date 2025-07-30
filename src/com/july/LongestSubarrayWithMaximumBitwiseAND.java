package com.july;

public class LongestSubarrayWithMaximumBitwiseAND {
    public static void main(String[] args) {
        int [] nums = {5,5,3,5};
        int res = longestSubarray(nums);
        System.out.println(res);
    }

    private static int longestSubarray(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int n = nums.length;
        int res =0;
        int maxLen =0;
        for(int i=0;i<n;i++){

            if(maxNum < nums[i]){
                maxLen = 0;
                maxNum = nums[i];
                res =0;
            }
            if(maxNum == nums[i]){
                maxLen +=1;
            }else maxLen = 0;
            res = Math.max(res, maxLen);
        }
        return res;
    }
}
