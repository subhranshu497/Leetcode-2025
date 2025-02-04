package com.februry;

public class MaximumAscendingSubarraySum {
    public static void main(String[] args) {
        int [] nums ={10,20,30,5,10,50};
        int sum = maxAscendingSum(nums);
        System.out.println(sum);
    }

    private static int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int tempSum = nums[0];
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                tempSum +=nums[i+1];
            }
            else {
                maxSum =Math.max(tempSum, maxSum);
                tempSum = nums[i+1];
            }
        }
        maxSum = Math.max(maxSum, tempSum);
        return maxSum;
    }
}
