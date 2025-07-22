package com.july;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public static void main(String[] args) {
        int [] nums = {4,2,4,5,6};
        int ans = maximumUniqueSubarray(nums);
        System.out.println(ans);
    }

    private static int maximumUniqueSubarray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;
        int right = 0;
        int left =0;
        Set<Integer> set = new HashSet<>();
        //set.add(nums[left]);
        int sum = 0;
        while(right <n){
            sum +=nums[right];
            int rNum = nums[right];
            while (set.contains(rNum)){
                sum -=nums[left];
                set.remove(nums[left]);
                //res = Math.max(res, sum);
                left++;
            }
            set.add(nums[right]);
            res = Math.max(res, sum);
            right++;
        }
        return res;
    }
}
