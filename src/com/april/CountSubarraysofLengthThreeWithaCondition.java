package com.april;

public class CountSubarraysofLengthThreeWithaCondition {
    public static void main(String[] args) {
        int [] nums = {10,0,-10};
        int count = countSubarrays1(nums);
        System.out.println(count);
    }

    private static int countSubarrays1(int[] nums) {
        int n = nums.length;
        int count =0;
        for(int i=2;i<n;i++){
            int sum = 2*(nums[i]+nums[i-2]);
            int denominator = nums[i-1];
            count +=sum == denominator ?1:0;
        }
        return count;
    }
}
