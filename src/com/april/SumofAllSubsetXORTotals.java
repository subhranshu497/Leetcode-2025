package com.april;

import java.util.ArrayList;
import java.util.List;

public class SumofAllSubsetXORTotals {
    public static void main(String[] args) {
        int [] nums = {5,1,6};
        int sum = subsetXORSum(nums);
        System.out.println(sum);
    }

    private static int subsetXORSum(int[] nums) {
        return xorSum(nums, 0,0);
    }

    private static int xorSum(int[] nums, int currentXor, int i) {
        //base condition
        if(i== nums.length) return currentXor;
        //take next
        int take = xorSum(nums, currentXor^nums[i],i+1);
        //skip next
        int skip = xorSum(nums, currentXor, i+1);

        return take+skip;
    }
}
