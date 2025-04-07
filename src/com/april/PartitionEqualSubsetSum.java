package com.april;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int [] nums = {1,2,3,5};
        boolean flag = canPartition(nums);
        System.out.println(flag);
    }

    private static boolean canPartition(int[] nums) {
        int sum =0;
        for(int num:nums){
            sum +=num;
        }
        if(sum % 2 !=0) return false;
        sum = sum/2;
        boolean [] dp = new boolean[sum+1];
        dp[0] = true;
        for(int i:nums){
            for(int j=sum;j>=i;j--){
                dp[j] = dp[j] | dp[j-i];
            }
        }
        return dp[sum];
    }
}
