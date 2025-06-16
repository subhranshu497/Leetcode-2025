package com.june;

import org.w3c.dom.ls.LSOutput;

public class MaximumDifferenceBetweenIncreasingElements {


    public static void main(String[] args) {
        int [] nums = {9,4,3,2};
        int maxDiff = maximumDifference(nums);
        System.out.println(maxDiff);
    }

    private static int maximumDifference(int[] nums) {
        int i =0;
        int j =1;
        int n = nums.length;
        int maxDiff = -1;
        while(i<n && j<n){
            if(nums[j] <= nums[i]){
                i=j;
            }else{
                maxDiff = Math.max(maxDiff, nums[j]-nums[i]);
            }
            j++;
        }
        return maxDiff;
    }
}
