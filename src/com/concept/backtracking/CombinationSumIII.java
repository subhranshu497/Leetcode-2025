package com.concept.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int n = 45;
        int k =9;
        List<List<Integer>> res = combinationSum3(n,k);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSum3(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        calculateCombSum3(n,k,res, new ArrayList<>(), 0,0, 0);
        return res;
    }

    private static void calculateCombSum3(int n, int k, List<List<Integer>> res, List<Integer> temp, int i, int sum, int numCount) {
        //base condition
        if(i<=9 && numCount==k){
            if(sum==n)
                res.add(new ArrayList<>(temp));
            return;
        }
        if(i>9)return;
        //do the operation
        temp.add(i+1);
        sum +=(i+1);
        calculateCombSum3(n,k,res,temp,i+1,sum,numCount+1);
        numCount -=1;
        sum -= temp.get(temp.size()-1);
        temp.remove(temp.size()-1);
        calculateCombSum3(n,k,res,temp,i+1,sum,numCount+1);
    }
}
