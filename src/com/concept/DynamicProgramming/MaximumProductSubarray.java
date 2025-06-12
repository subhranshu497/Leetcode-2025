package com.concept.DynamicProgramming;

public class MaximumProductSubarray
{
    public static void main(String[] args) {
        int [] nums = {-2,0,-1};
        int prod = maxProduct(nums);
        System.out.println(prod);
    }

    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int prefix = 1;
        //find prefix prod
        for(int i=0;i<n;i++){
            if(prefix==0){
                prefix =1;
            }
            prefix *=nums[i];
            max = Math.max(prefix, max);
        }
        int suffix = 1;
        //find suffix prod
        for(int i=n-1;i>=0;i--){
            if(suffix==0){
                suffix =1;
            }
            suffix *=nums[i];
            max = Math.max(max, suffix);
        }
        return max;
    }
}
