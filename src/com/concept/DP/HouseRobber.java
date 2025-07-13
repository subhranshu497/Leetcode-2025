package com.concept.DP;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int [] houses = {6,7,1,3,8,2,4};
        //int money = maxRobRecursionAndMemo(houses);
        int money = maxRobDP(houses);
        System.out.println(money);
    }

    private static int maxRobDP(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        //when robber robs 0 houses , then he got 0 money
        dp[0] =0;
        dp[1] = nums[0];
        for(int i=2;i<=n;i++){
            int take = nums[i-1]+dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(take, skip);
        }
        return dp[n];
    }

    private static int maxRobRecursionAndMemo(int[] houses) {
        int n = houses.length;
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        int money = solveMaxRobRecursionAndMemo(houses,0,n, memo);
        return money;
    }

    private static int solveMaxRobRecursionAndMemo(int[] houses, int i, int n, int [] memo) {
        //base condition
        if(i>=n){
            return 0;
        }
        if(memo[i] != -1)return memo[i];
        int take = houses[i]+solveMaxRobRecursionAndMemo(houses,i+2,n, memo);
        int skip = solveMaxRobRecursionAndMemo(houses,i+1,n, memo);

        return memo[i] = Math.max(take, skip);
    }
}
