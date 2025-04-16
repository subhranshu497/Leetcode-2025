package com.april;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountTheNumberOfGoodSubarrays {
    public static void main(String[] args) {
        int [] nums = {1,1,1,1,1};
        int k = 10;
        long count = countGood(nums, k);
        System.out.println(count);
    }

    private static long countGood(int[] nums, int k) {
        int n = nums.length;
        int i =0;
        int j =0;
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pair = 0;
        while(j<n){
            pair +=map.getOrDefault(nums[j],0);
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            while(pair >=k){
                count += (n-j);
                map.put(nums[i], map.getOrDefault(nums[i],0)-1);
                pair -= map.getOrDefault(nums[i],0);
                i++;
            }
            j++;
        }
        return count;
    }
}
