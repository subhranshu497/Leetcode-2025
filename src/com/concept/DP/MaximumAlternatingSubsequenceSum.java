package com.concept.DP;

import java.util.Arrays;

public class MaximumAlternatingSubsequenceSum {
    public static void main(String[] args) {
        int [] nums = {4,2,5,3};
        long sum = maxAlternatingSumDP(nums);
        System.out.println(sum);
    }

    private static long maxAlternatingSumDP(int[] nums) {
        int n = nums.length;
        long [][] dp = new long[n+1][2];
        for(int i =1; i<=n;i++){
            dp[i][0] = Math.max(dp[i-1][1]-nums[i-1], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]+nums[i-1], dp[i-1][1]);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    private static long maxAlternatingSum(int[] nums) {
        long [][] memo = new long[nums.length+1][2];
        for(long [] arr:memo)
            Arrays.fill(arr, -1);
        long sum = maxAlternatingSumRecursion(nums,0,true, memo);
        System.out.println(sum);
        return sum;
    }

    private static long maxAlternatingSumRecursion(int[] nums, int i, boolean isEven, long[][] memo) {
        //base condition
        if(i >= nums.length){
            return 0;
        }
        int pairty = isEven?1:0;
        if(memo[i][pairty] !=-1) return memo[i][pairty];
        //in case of skip , no flip of flag
        long skip = maxAlternatingSumRecursion(nums,i+1,isEven, memo);
        //in case of take flip the flag, so val also be flipped
        //here in case of odd , minus
        int val = nums[i];
        if(!isEven){
            val = -val;
        }
        long take = val+maxAlternatingSumRecursion(nums,i+1,!isEven, memo);

        return memo[i][pairty] = Math.max(take, skip);
    }
}
