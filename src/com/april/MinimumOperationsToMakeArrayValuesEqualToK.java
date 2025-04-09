package com.april;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsToMakeArrayValuesEqualToK {
    public static void main(String[] args) {
        int [] nums = {9,7,5,3};
        int k = 1;
        int ops = minOperations2(nums, k);
        System.out.println(ops);
    }

    private static int minOperations2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
            if(num <k)
                return -1;
        }
        return set.contains(k)?set.size()-1:set.size();
    }
}
