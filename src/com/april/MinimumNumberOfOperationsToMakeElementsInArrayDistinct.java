package com.april;

import java.util.*;

public class MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    public static void main(String[] args) {
        int [] nums = {4,5,6,4,4};
        int ops = minimumOperations(nums);
        System.out.println(ops);
    }

    private static int minimumOperations(int[] nums) {
        int n = nums.length;
        double breakpoint =-1;
        Set<Integer> set = new HashSet<>();
        for(int i=n-1;i>=0;i--){
            if(set.contains(nums[i])){
                breakpoint =i;
                break;
            }
                set.add(nums[i]);

        }
        return breakpoint==-1?0: (int) Math.ceil((breakpoint + 1) / 3);
    }
}
