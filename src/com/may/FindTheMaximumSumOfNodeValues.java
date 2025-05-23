package com.may;

import java.util.Map;

public class FindTheMaximumSumOfNodeValues {
    public static void main(String[] args) {
        int [] nums = {1,2,1};
        int k = 3;
        int [][] edges = {{0,1},{0,2}};
        long max = maximumValueSum(nums, edges, k);
        System.out.println(max);
    }

    private static long maximumValueSum(int[] nums, int[][] edges, int k) {
        long sum =0;
        int xorCount=0;
        long minLoss = Long.MAX_VALUE;
        for(long num:nums){
            long xor = num^k;
            if(xor >num){
                xorCount++;
                sum +=xor;
            }
            else {
                sum +=num;
            }
            minLoss = Math.min(minLoss, Math.abs(num-(num^k)));
        }
        //now check for xor count, if it is odd then find minloss
        if(xorCount % 2 ==0)return sum;

        return sum-minLoss;
    }
}
