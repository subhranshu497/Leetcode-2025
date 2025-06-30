package com.june;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
            int [] nums ={1,3,2,2,5,2,3,7};
            int res = findLHS(nums);
        System.out.println(res);
    }

    private static int findLHS(int[] nums) {
        int res =0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for(int i=0;i< nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(map);
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(map.containsKey(key+1)){
                int val2 = map.get(key+1);
                res = Math.max(res, val+val2);
                map.remove(key);
            }
        }
        return res;
    }
}
