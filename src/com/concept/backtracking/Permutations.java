package com.concept.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        List<List<Integer>> res = permute(nums);
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        findAllPermutation(nums, res,new HashSet<>(), n,new ArrayList<>());
        System.out.println(res);
        return res;
    }

    private static void findAllPermutation(int[] nums, List<List<Integer>> res, Set<Integer> set, int n, List<Integer> temp) {
        //base condition
        if(temp.size()==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int idx=0;idx<n;idx++){
            if(!set.contains(nums[idx])){
                temp.add(nums[idx]);//do
                set.add(nums[idx]);
                findAllPermutation(nums,res,set,n,temp); //explore
                set.remove(nums[idx]);
                temp.remove(temp.size()-1); //undo
            }

        }

    }
}
