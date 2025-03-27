package com.march;

import java.util.*;

public class MinimumIndexOfValidSplit {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3,3,3,3,7,2,2);
        int idx = minimumIndex(nums);
        System.out.println(idx);
    }

    private static int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map1= new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0;i<nums.size();i++){
            map2.put(nums.get(i), map2.getOrDefault(nums.get(i),0)+1);
        }
        for(int i=0;i<nums.size();i++){
            int num = nums.get(i);
            map1.put(num, map1.getOrDefault(num,0)+1);
            map2.put(num, map2.getOrDefault(num,0)-1);
            int n1 = i+1;
            int n2 = nums.size()-i-1;
            if(map1.get(num)>(n1/2) && map2.get(num)>(n2/2))
                return i;
        }
        return -1;
    }
}
