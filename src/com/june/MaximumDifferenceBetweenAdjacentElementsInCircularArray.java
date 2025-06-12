package com.june;

public class MaximumDifferenceBetweenAdjacentElementsInCircularArray {
    public static void main(String[] args) {
        int [] nums ={1,2,4};
        int diff = maxAdjacentDistance(nums);
        System.out.println(diff);
    }

    private static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int diff = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            diff = Math.max(diff, Math.abs(nums[i]-nums[i+1]));
        }
        return Math.max(diff, Math.abs(nums[n-1]-nums[0]));
    }
}
