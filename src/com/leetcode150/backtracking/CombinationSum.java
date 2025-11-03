package com.leetcode150.backtracking;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int [] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = combinationSumI(nums, target);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSumI(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        int n = nums.length;
        comSumSolver(nums,n, target, res, new ArrayList<>(), 0,0);
        return res;
    }

    private static void comSumSolver(int[] nums, int n, int target, List<List<Integer>> res, List<Integer> ds, int i, int sum) {
        //base condition
        if(i<n && sum==target){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(i>= n || sum > target) return;

        ds.add(nums[i]);
        sum +=nums[i];
        comSumSolver(nums, n, target, res,ds,i,sum);
        sum -=ds.get(ds.size()-1);
        ds.remove(ds.size()-1);
        comSumSolver(nums, n, target, res,ds,i+1,sum);
    }
}
