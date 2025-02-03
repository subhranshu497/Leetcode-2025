package com.februry;

import java.util.Map;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public static void main(String[] args) {
        int [] nums = {3,2,1};
        int count = longestMonotonicSubarray(nums);
        System.out.println(count);
    }

    private static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int ans =Integer.MIN_VALUE;
        int count =1;
        int ans1 = count;
        int ans2 = count;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                count++;
            }else{
                ans1 = Math.max(ans1, count);
                count=1;
            }
        }
        ans1 = Math.max(ans1, count);
        count=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
            }else{
                ans2 = Math.max(ans2, count);
                count=1;
            }
        }
        ans2 = Math.max(ans2, count);
        ans = Math.max(ans1, ans2);
        return ans;
    }
}
