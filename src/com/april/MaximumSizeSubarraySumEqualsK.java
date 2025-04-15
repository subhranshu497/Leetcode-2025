package com.april;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
        int [] nums = {1,-1, 5,-2,3};
        int  k =3;
       int size = maxSubArrayLen(nums, k);
        System.out.println(size);
    }

    private static int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        //find prefix sum
        int sum =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int res = 0;
        for(int i=0;i<n;i++){
            sum +=nums[i];
            if(map.containsKey(sum-k)){
                res = Math.max(res, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return res;
    }
}
