package com.februry;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        long badPairs = countBadPairs(nums);
        System.out.println(badPairs);
    }

    private static long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Long> map = new HashMap<>();
        long totalPairs = n*(n-1)/2;
        for(int i=0;i<n;i++){
            int diff = nums[i]-i;
            totalPairs -=map.getOrDefault(diff, 0L);
            map.put(diff, map.getOrDefault(diff, 0L)+1);
        }
        return totalPairs;
    }
}
