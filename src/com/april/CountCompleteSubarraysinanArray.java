package com.april;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountCompleteSubarraysinanArray {
    public static void main(String[] args) {
        int [] nums = {5,5,5,5};
        int count = countCompleteSubarrays(nums);
        System.out.println(count);
    }

    private static int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count =0;
        int n = nums.length;
        for(int num:nums){
            set.add(num);
        }
        int size = set.size();
        int left =0;
        int right =0;
        while(left <n){
            Set<Integer> tempSet = new HashSet<>();
            while(right <n){
                tempSet.add(nums[right]);
                if(tempSet.size() == size){
                    count++;
                }
                right++;
            }
            tempSet.remove(nums[left]);
            left++;
            right =left;
        }

        return count;
    }
}
