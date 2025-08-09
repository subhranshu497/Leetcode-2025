package com.top.interview150.oneDDP;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        int money = robTop150(nums);
        System.out.println(money);
    }

    private static int robTop150(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        //if there is no houses
        dp[0] =0;
        int money = 0;
        //if there is only one house
        dp[1] =nums[0];
        for(int i=2;i<=n;i++){
            int take = dp[i-2]+nums[i-1];
            int skip = dp[i-1];
            dp[i] = Math.max(take, skip);
        }
        return dp[n];
    }
}
