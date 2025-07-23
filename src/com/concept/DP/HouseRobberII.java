package com.concept.DP;

public class HouseRobberII {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        int money = robII(nums);
        System.out.println(money);
    }

    private static int robII(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        //case 1 - 0 to n-2
        int [] nums1 = new int[n-1];

        for(int i=0;i<n-1;i++)
            nums1[i]=nums[i];

        //to calculate money
        int money1 = calculateRobbedMoney(nums1);
        //case 2 - 1 to n-1
        int [] nums2 = new int[n-1];

        for(int i=1;i<n;i++)
            nums2[i-1]=nums[i];
        int money2 = calculateRobbedMoney(nums2);
        return Math.max(money2, money1);
    }

    private static int calculateRobbedMoney(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2;i<=n;i++){
            int take = dp[i-2]+nums[i-1];
            int skip = dp[i-1];
            dp[i] = Math.max(take, skip);
        }
        return dp[n];
    }
}
