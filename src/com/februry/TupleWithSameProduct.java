package com.februry;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public static void main(String[] args) {
        int [] nums = {1,2,4,5,10};
        int ans = tupleSameProduct(nums);
        System.out.println(ans);
    }
    public static int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!map.containsKey(nums[i]*nums[j]))
                    map.put(nums[i]*nums[j],0);
                map.put(nums[i]*nums[j], map.get(nums[i]*nums[j])+1);
            }
        }
        int ans =0;
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            int val = e.getValue();
            ans +=val*(val-1)*4;
        }
        return ans;
    }
}
