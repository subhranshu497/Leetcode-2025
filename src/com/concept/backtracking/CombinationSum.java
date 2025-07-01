package com.concept.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {
    public static void main(String[] args) {
        int [] candidates = {2,3,6,7};
        int target =7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n =candidates.length;
        Arrays.sort(candidates);
        solveComSum(candidates, target, new ArrayList<>(),0,n, res);
        return res;
    }

    private static void solveComSum(int[] candidates, int target, List<Integer> temp, int i, int n, List<List<Integer>> res) {
        //base condition
        if (i >= n) {
return;
        }
        if(target<=0){
            if(target==0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(candidates[i]);
        solveComSum(candidates, target-candidates[i],temp,i,n, res);
        target +=candidates[i];
        temp.remove(temp.getLast());
        solveComSum(candidates, target-candidates[i],temp,i+1,n, res);
    }

//    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Set<List<Integer>> res = new HashSet<>();
//        Arrays.sort(candidates);
//        int n = candidates.length;
//        for(int i=0;i<n;i++){
//            solveComSum(res, candidates, target,0,0,n, new ArrayList<>());
//        }
//        return res.stream().collect(Collectors.toList());
//    }
//
//    private static void solveComSum(Set<List<Integer>> res, int[] candidates, int target, int idx, int sum, int n, List<Integer> temp) {
//        //base condition
//        if(target==sum){
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//        if(sum>target){
//            return;
//        }
//        for(int i=idx;i<n;i++){
//            sum +=candidates[i];
//            temp.add(candidates[i]);
//            solveComSum(res,candidates,target,i,sum,n,temp);
//            sum -= temp.getLast();
//            temp.remove(temp.size()-1);
//        }
//    }
}
