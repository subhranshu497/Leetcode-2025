package com.nov;

public class MinimumOperationstoMakeArraySumDivisiblebyK {
    public static void main(String[] args) {
        int [] nums = {3,9,7};
        int k =5;
        int res = minOperationsIII(nums, k);
        System.out.println(res);
    }

    private static int minOperationsIII(int[] nums, int k) {
        int sum = 0;
        for(int num:nums)
            sum +=num;
        return sum % k;
    }
}
