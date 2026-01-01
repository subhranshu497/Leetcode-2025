package com.oct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyofanElementAfterPerformingOperationsI {
    public static void main(String[] args) {
        int [] nums = {1,4,5};
        int k = 1;
        int numOperations =2;
        int res = maxFrequency(nums,k,numOperations);
        System.out.println(res);
    }

    private static int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int maxEl = Arrays.stream(nums).max().getAsInt()+k;
        int [] diff = new int[maxEl+2];
        Map<Integer, Integer> freq = new HashMap<>();
        //apply diff array technique
        for(int i=0;i<n;i++){
            int left = Math.max(nums[i]-k,0);
            int right = Math.min(nums[i]+k,maxEl);
            diff[left]++;
            diff[right+1]--;
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        int result =1;
        for(int target=0;target <=maxEl;target++){
            if(target > 0) diff[target] +=diff[target-1];
            int targetFreq = freq.getOrDefault(target, 0);
            int needConversion = diff[target]-targetFreq;
            int maxPossible = Math.min(numOperations, needConversion);
            result = Math.max(result, maxPossible+targetFreq);
        }
        return result;
    }
}
