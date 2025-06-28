package com.concept.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        calculateSubSets(nums, res, 0, new ArrayList<>());
        return res;
    }

    private static void calculateSubSets(int[] nums, List<List<Integer>> res, int i, List<Integer> list) {

        //base condition
        if(i>=nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        //do the operation
        list.add(nums[i]);
        calculateSubSets(nums,res,i+1,list);
        //backtrack
        list.remove(list.size()-1);
        calculateSubSets(nums,res,i+1,list);
    }
}
