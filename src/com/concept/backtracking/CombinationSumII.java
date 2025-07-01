package com.concept.backtracking;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        solveComSum2(candidates,0, target,new ArrayList<>(), res);
        return res;
    }

    private static void solveComSum2(int[] candidates,int idx, int target, List<Integer> temp, List<List<Integer>> res) {
        //base condition
        if(target<=0){
            if(target==0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1])continue;
            temp.add(candidates[i]); //do
            solveComSum2(candidates, i+1,target-candidates[i], temp,res); //explore
            temp.remove(temp.getLast()); //undo
        }

    }

//    private static void solveComSum2(Map<Integer, Integer> map, int target, List<Integer> temp, List<List<Integer>> res) {
//        //base condition
//        if(target==0){
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//        for (Map.Entry<Integer, Integer> e:map.entrySet()){
//            int key = e.getKey();
//            int val = e.getValue();
//            if(map.getOrDefault(key,0)>0){
//                target -=key;
//                temp.add(key);
//                val -=1;
//                map.put(key, val);
//                solveComSum2(map,target,temp,res);
//                val +=1;
//                target +=key;
//                map.put(key, val);
//                temp.remove(temp.size()-1);
//            }
//
//        }
//    }
}
