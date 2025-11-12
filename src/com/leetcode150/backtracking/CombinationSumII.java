package com.leetcode150.backtracking;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int [] candidates = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> res = combinationSumI2(candidates, target);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSumI2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        comSumI2Solver(candidates, n, res, new ArrayList<>(),target, 0,0);
        return res;
    }

    private static void comSumI2Solver(int[] candidates, int n, List<List<Integer>> res, List<Integer> ds, int target, int i, int sum) {
        //base condition
        if(i<n && sum==target){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(i>=n || sum > target) return;
        for(int idx=i;idx<n;idx++){
            //start backtracking
            //do
            ds.add(candidates[i]);
            sum +=candidates[i];
            //explore
            comSumI2Solver(candidates, n, res,ds,target, idx+1, sum);
            //undo
            sum -=ds.get(ds.size()-1);
            ds.remove(ds.size()-1);
            comSumI2Solver(candidates,n,res,ds,target,idx+1,sum);
        }
    }
}
