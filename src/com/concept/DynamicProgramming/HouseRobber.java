package com.concept.DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    private static int money=0;
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        money = robDP(nums);
        System.out.println(money);
    }

    private static int rob(int[] nums) {
        int n = nums.length;
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return solveRob(0,nums,0, memo);
    }

    private static int solveRob(int i, int[] nums, int tempMoney, int [] memo) {
        //bc
        if(i>=nums.length){
            return 0;
        }
        if(memo[i] !=-1) return memo[i];
        //take
        int take= nums[i]+solveRob(i+2, nums, tempMoney, memo);
        int skip = solveRob(i+1, nums, tempMoney,memo);
        return memo[i]=Math.max(take, skip);

    }
    private static int robDP(int[] nums) {
        int n = nums.length;
        int [] money = new int[n+1];
        //if the robber robs 0 houses then will get 0 money
        money[0] = 0;
        // if there is only one house exists then , money robbber will get
        money[1] = nums[0];
        for(int i=2;i<=n;i++){
            int take = money[i-2]+nums[i-1];
            int skip = money[i-1];
            money[i] = Math.max(take, skip);
        }
        return money[n];
    }
}
