package com.concept.recursion;

import java.util.Arrays;

public class MaxCutRod {
    public static void main(String[] args) {
        int n =4 ,x =2, y=1,z=1;
        int cut = maxCut(n,x,y,z);
        System.out.println(cut);
    }

    private static int maxCut(int n, int x, int y, int z) {
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        int res=maxCutHelper(n,x,y,z,memo);
        if(res <0) return 0;
        return res;
    }

    private static int maxCutHelper(int n, int x, int y, int z, int [] memo) {
        //base condition
        if(n==0)
            return 0;
        if(n<0)
            return -1;
        if(memo[n]!=-1) return memo[n];
        int cutX = maxCutHelper(n-x, x,y,z,memo);
        int cutY = maxCutHelper(n-y, x,y,z, memo);
        int cutZ = maxCutHelper(n-z, x,y,z, memo);

        int max = Math.max(cutX, Math.max(cutY,cutZ));
        if (max == -1) {
            return memo[n]=-1;
        }

        return memo[n]=max + 1;
    }
}
