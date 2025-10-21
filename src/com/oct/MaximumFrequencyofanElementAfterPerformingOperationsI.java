package com.oct;

import java.util.Arrays;

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
        int max = Arrays.stream(nums).max().getAsInt();
        max +=k;
        //take the frequency Array
        int [] frequency = new int[max+k+1];
        for(int i=0;i<n;i++){
            frequency[nums[i]]++;
        }
        //calculate the cumulative sum
        for(int i=1;i<=max;i++){
            frequency[i] +=frequency[i-1];
        }
        int res = 0;
        for(int target =0;target<=max;target++){
            if(frequency[target]==0)continue;
            int l = Math.max(0,target-k);
            int r = Math.min(max,target+k);
            int totalCoun = frequency[r]-(l>0?frequency[l-1]:0);
            int targetCount = frequency[target]-(target>0?frequency[target-1]:0);
            int needConversion = totalCoun - targetCount;
            int maxPossibleFreq = targetCount + Math.min(needConversion, numOperations);
            res = Math.max(res, maxPossibleFreq);
        }
        return res;
    }
}
