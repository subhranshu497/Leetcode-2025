package com.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int [] nums = {1,2,4,8};
        List<Integer> result = largestDivisibleSubset(nums);
        System.out.println(result);
    }

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        int [] prevIndex = new int[n];
        Arrays.fill(prevIndex, -1);

        int lastIdx = 0;
        int maxLength =1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j]==0){
                    if(dp[i] <dp[j]+1){
                        dp[i] = dp[j]+1;
                        prevIndex[i] =j;
                    }
                    if(dp[i] > maxLength){
                        maxLength = dp[i];
                        lastIdx =i;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (lastIdx >=0){
            res.add(nums[lastIdx]);
            lastIdx = prevIndex[lastIdx];
        }
        return res;
    }

    private static List<Integer> largestDivisibleSubset1(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solveLDS(nums, ds, result, 0,-1);
        return result;
    }

    private static void solveLDS(int[] nums, List<Integer> ds,List<Integer> result, int i, int prev) {
        //base condition
        if(i >=nums.length){
            if(ds.size()>result.size()){
                result.clear();
                result.addAll(ds);
            }
            return;
        }
        //take
        if(prev ==-1 || nums[i]%prev==0){
            ds.add(nums[i]);
            solveLDS(nums, ds, result, i+1, nums[i]);
            ds.removeLast();
        }
        //skip
        solveLDS(nums, ds, result, i+1, prev);
    }
}
