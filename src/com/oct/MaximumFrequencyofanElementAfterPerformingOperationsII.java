package com.oct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaximumFrequencyofanElementAfterPerformingOperationsII {
    public static void main(String[] args) {
        int [] nums = {5,11,20,20};
        int k = 5;
        int numOperations =1;
        int res = maxFrequency(nums,k,numOperations);
        System.out.println(res);
    }

    private static int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        int maxEl = Arrays.stream(nums).max().getAsInt()+k;
        TreeMap<Integer, Integer> diff = new TreeMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        //apply diff array technique
        for(int i=0;i<n;i++){
            int left = Math.max(nums[i]-k,0);
            int right = Math.min(nums[i]+k,maxEl);
            diff.put(left, diff.getOrDefault(left,0)+1);
            diff.put(right+1, diff.getOrDefault(right+1,0)-1);
            diff.putIfAbsent(nums[i], diff.getOrDefault(nums[i], 0));
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        System.out.println("Diff Map "+diff);
        System.out.println("Freq Map "+freq);
        int result =1;
        int cumSum =0;
        for(Map.Entry<Integer, Integer> e:diff.entrySet()){
            int target = e.getKey();
            int val = e.getValue();
            cumSum +=val;
            int targetFreq = freq.getOrDefault(target, 0);
            int needConversion = cumSum-targetFreq;
            int maxPossible = Math.min(numOperations, needConversion);
            result = Math.max(result, maxPossible+targetFreq);
        }
        return result;
    }
}
