package com.concept.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        List<List<Integer>> res = permuteI(nums);
    }

    private static List<List<Integer>> permuteI(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
            solvePermutation(res, n, map,  new ArrayList<>());
        System.out.println(res);
        return res;
    }

    private static void solvePermutation(List<List<Integer>> res, int n, Map<Integer, Integer> map, List<Integer> temp) {
        //base condition
        if(temp.size()==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            int key = e.getKey();
            int val = e.getValue();
            if(val>0){
                val -=1;
                temp.add(key);//do
                map.put(key,val);
                solvePermutation(res,n,map,temp); //explore
                temp.remove(temp.size()-1);
                map.put(key, map.getOrDefault(key,0)+1);
            }
        }
    }
}
