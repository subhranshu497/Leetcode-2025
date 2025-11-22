package com.nov;

public class FindMinimumOperationstoMakeAllElementsDivisiblebyThree {
    public static void main(String[] args) {
        int [] nums = {3,6,9};
        int ops = minimumOperationsI(nums);
        System.out.println(ops);
    }

    private static int minimumOperationsI(int[] nums) {
        int n = nums.length;
        int ops = 0;
        for(int num:nums){
           ops += num % 3 ==0?0:1;
        }
        return ops;
    }
}
