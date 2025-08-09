package com.concept.recursion;

import java.util.Arrays;

public class MaximumLengthofPairChain {
    public static void main(String[] args) {
        int [][] pairs = {{1,2},{7,8},{4,5}};
        int len = findLongestChain(pairs);
        System.out.println(len);
    }

    private static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->a[0]-b[0]);
        int [][] memo = new int[pairs.length+1][pairs.length+1];
        for(int [] arr:memo)
            Arrays.fill(arr, -1);
        int res = findPairsLengthRecursion(pairs,-1,0, memo);
        return res;
    }

    private static int findPairsLengthRecursion(int[][] pairs, int prevIdx, int currIdx, int [][] memo) {
        if(currIdx>=pairs.length)
            return 0;
        int setPrevIdx = prevIdx+1;
        if(prevIdx==-1)
            setPrevIdx = 0;
        if(memo[setPrevIdx][currIdx] !=-1) return memo[setPrevIdx][currIdx];
        int take = 0;
        if(prevIdx ==-1 || pairs[prevIdx][1]<pairs[currIdx][0]){
            take = 1+findPairsLengthRecursion(pairs, currIdx, currIdx+1, memo);
        }
        //skip case
        int skip = findPairsLengthRecursion(pairs,prevIdx, currIdx+1,memo);
        return memo[setPrevIdx][currIdx] = Math.max(take, skip);
    }
}
