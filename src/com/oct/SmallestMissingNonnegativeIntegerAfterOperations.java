package com.oct;

import java.util.HashMap;
import java.util.Map;

public class SmallestMissingNonnegativeIntegerAfterOperations {
    public static void main(String[] args) {
        int [] nums = {1,-10,7,13,6,8};
        int value = 5;
        int mex = findSmallestInteger(nums, value);
        System.out.println(mex);
    }

    private static int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();
        int MEX =0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            int key =0;
            if(nums[i]<0){
                key = ((nums[i]%value)+value)%value;
            }else key = nums[i]%value;
            map.put(key, map.getOrDefault(key,0)+1);
        }
        //check linearly for mex
        int i=0;
        while (true){
            int val = i%value;
            if(map.containsKey(val)){
                map.put(val, map.getOrDefault(val,0)-1);
                if(map.get(val)==0)
                    map.remove(val);
            }else {
                return i;
            }
            i++;
        }
    }
}
