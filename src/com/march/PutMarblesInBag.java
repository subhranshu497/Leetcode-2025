package com.march;

import java.util.Arrays;

public class PutMarblesInBag {
    public static void main(String[] args) {
        int [] weigths = {1,3,5,1};
        int k = 2;
        long res = putMarbles(weigths, k);
        System.out.println(res);
    }

    private static long putMarbles(int[] weigths, int k) {
        int n = weigths.length;
        int m = n-1;
        int [] pairSum = new int[m];
        for(int i=0;i<m;i++){
            pairSum[i] = weigths[i]+weigths[i+1];
        }
        Arrays.sort(pairSum);
        long minSum =0;
        long maxSum =0;
        for(int i=0;i<k-1;i++){
            minSum +=pairSum[i];
            maxSum +=pairSum[m-i-1];
        }
        return maxSum-minSum;
    }
}
