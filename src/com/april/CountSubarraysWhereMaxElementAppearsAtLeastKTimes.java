package com.april;

import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static void main(String[] args) {
        int [] nums = {1,3,2,3,3};
        int k =2;
        int count = countSubarrays3(nums, k);
        System.out.println(count);
    }

    private static int countSubarrays3(int[] nums, int k) {
        int n = nums.length;
        int count =0;
        int ans =0;
        int left=0;
        int right =0;
        int max = Integer.MIN_VALUE;
        for(int num:nums)
            max = Math.max(max, num);
        while(right <n){
            if(nums[right]==max) count++;
            while(count >=k){
                ans +=n-right;
                if(nums[left]==max) count--;
                left++;
            }
            right++;
        }
        return ans;
    }
}
