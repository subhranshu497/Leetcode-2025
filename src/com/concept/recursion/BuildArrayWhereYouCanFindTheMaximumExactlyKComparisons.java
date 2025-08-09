package com.concept.recursion;

import java.util.Arrays;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons {
    private static int mod = 1000_000_007;
    public static void main(String[] args) {
        int n =2, m=3, k=1;
        int numOfArr = numOfArrays(n,m,k);
        System.out.println(numOfArr);
    }

    /**
     * as per the given algo in the qn, maxElement =-1
     * array would be taken into consideration if searchCost ==k
     * where searchcost is the comparasion cost
     * when maxCost < elemnt, then searchCost would be incremented by 1
     * @param n
     * @param m
     * @param k
     * @return
     */

    private static int numOfArrays(int n, int m, int k) {
        int maxElement =0;
        int searchCost =0;
        int [][][] memo = new int[51][101][51];
        for(int [][] twoD:memo){
            for(int [] arr: twoD)
                Arrays.fill(arr, -1);
        }
        int res = numOfArraysRecursion(maxElement, searchCost, n,m,k,0, memo);
        return res;
    }

    private static int numOfArraysRecursion(int maxElement, int searchCost, int n, int m, int k, int idx,  int [][][] memo) {
        //base condition
        if(idx == n){
            if(searchCost==k){
                return 1;
            }else return 0;
        }
        if(memo[idx][maxElement][searchCost] != -1) return memo[idx][maxElement][searchCost] % mod;
        int res =0;
        //run the loop and find the elements
        for(int i=1;i<=m;i++){
            if(maxElement < i){
                res = (res+numOfArraysRecursion(i, searchCost+1, n,m,k,idx+1, memo))%mod;
            }else res = (res+numOfArraysRecursion(maxElement, searchCost, n,m,k,idx+1, memo))%mod;
        }
        return memo[idx][maxElement][searchCost]=res;
    }
}
