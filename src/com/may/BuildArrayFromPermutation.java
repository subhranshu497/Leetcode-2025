package com.may;

import java.util.HashMap;
import java.util.Map;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        int [] result = buildArray(nums);
        for(int num:nums)
            System.out.print(num+", ");
    }

    private static int[] buildArray(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];
        for(int i=0;i<n;i++){
            int temp = nums[i];
            result[i] = nums[temp];
        }
        return result;
    }
}
