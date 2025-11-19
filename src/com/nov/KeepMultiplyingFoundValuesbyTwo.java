package com.nov;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesbyTwo {
    public static void main(String[] args) {
        int [] nums = {5,3,6,1,12};
        int original = 3;
        int res = findFinalValue(nums, original);
        System.out.println(res);
    }

    private static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        while(set.contains(original)){
            original *=2;
        }
        return original;
    }
}
