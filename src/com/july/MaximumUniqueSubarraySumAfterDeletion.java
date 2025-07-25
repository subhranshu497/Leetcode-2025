package com.july;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumUniqueSubarraySumAfterDeletion {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int sum = maxSum(nums);
        System.out.println(sum);
    }

    private static int maxSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        if(nums[n-1]<=0) return nums[n-1];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int num:set){
            if(num>=0)
                res +=num;
        }
        return res;
    }
}
