package com.oct;

import java.util.Arrays;

public class MaximumNumberofDistinctElementsAfterOperations {
    public static void main(String[] args) {
        int [] nums = {1,2,2,3,3,4};
        int k = 2;
        int res = maxDistinctElements(nums, k);
        System.out.println(res);
    }

    private static int maxDistinctElements(int[] nums, int k) {
        int count =0;
        Arrays.sort(nums);
        int prev = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int lowerRange = nums[i]-k;
            int upperRange = nums[i]+k;
            if(prev <lowerRange){
                prev = lowerRange;
                count++;
            }else if(prev <upperRange){
                prev +=1;
                count++;
            }
        }
        return count;
    }
}
