package com.concept.recursion;

import java.util.Arrays;
import java.util.Map;

public class JumpGame {
    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        boolean flag = jumpFn(nums);
        System.out.println(flag);
    }

    //using DP
    private static boolean jumpFn(int[] nums) {
        int n = nums.length;
        boolean [] dp = new boolean[n];
        dp[0] = true;
        for(int i=1;i<n;i++){
            int maxStps = nums[i];
            for(int step=i-1;step>=0;step--){
                if(dp[step] && step+nums[step] >=i){
                    dp[i] =true;
                    break;
                }
            }
        }
        return dp[n-1];
    }

    private static boolean jumpFn1(int[] nums) {
        int n = nums.length;
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return solveJump(nums, 0, n, memo);
    }

    private static boolean solveJump(int[] nums, int i, int n, int[] memo) {
        //base condition
        //at any point if i>=n-1 return true, i.e end reached
        if(i >= n-1)return true;
        if(memo[i] !=-1) return memo[i]==1;
        //run a loop to jump each step at a time
        for(int step=1;step<=nums[i];step++){
            if(solveJump(nums, i+step, n, memo)){
                memo[i]=1;
                return true;
            }
        }
        memo[i]=0;
        return false;
    }
}
