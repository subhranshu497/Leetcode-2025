package com.dec;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CountPartitionsWithMaxMinDifferenceatMostK {
    private static int MOD = 1000000007;
    public static void main(String[] args) {
        int [] nums = {9,4,1,3,7};
        int k = 4;
        int res = countPartitionsI(nums, k);
        System.out.println(res);
    }

    private static int countPartitionsI(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int i = 0, j = 0;

        while (j < n) {

            while (!maxQ.isEmpty() && nums[j] > nums[maxQ.peekLast()])
                maxQ.pollLast();
            maxQ.addLast(j);

            while (!minQ.isEmpty() && nums[j] < nums[minQ.peekLast()])
                minQ.pollLast();
            minQ.addLast(j);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                i++;
                if (!maxQ.isEmpty() && maxQ.peekFirst() < i) maxQ.pollFirst();
                if (!minQ.isEmpty() && minQ.peekFirst() < i) minQ.pollFirst();
            }

            long val = (pref[j] - (i > 0 ? pref[i - 1] : 0) + MOD) % MOD;

            dp[j + 1] = val;
            pref[j + 1] = (pref[j] + dp[j + 1]) % MOD;

            j++;
        }

        return (int) dp[n];
    }

    private static int countPartitionsSolve(int[] nums, int k, int i, int n, int [] memo) {
        //base condition
        if(i >= n)return 1;
        if(memo[i] !=-1) return memo[i];
        int minEl = Integer.MAX_VALUE;
        int maxEl = Integer.MIN_VALUE;
        int ways = 0;
        for(int j=i;j<n;j++){
            minEl = Math.min(minEl,nums[j]);
            maxEl = Math.max(maxEl, nums[j]);
            if(maxEl-minEl <=k){
                ways =(ways+countPartitionsSolve(nums,k,j+1,n,memo))%MOD;
            }
        }
        return memo[i] = ways;
    }
}
