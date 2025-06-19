package com.june;

import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int k = 1;
        int sub = partitionArray(nums, k);
        System.out.println(sub);
    }

    private static int partitionArray(int[] nums, int k) {
        int n = nums.length;
        int sub = 1;
        if(n==1) return sub;
        int i =0;
        int j = i+1;
        Arrays.sort(nums);
        while(i<n & j<n){
            if(nums[j]-nums[i] > k){
                sub +=1;
                i=j;
            }
            j++;
        }
        return sub;
    }
}
