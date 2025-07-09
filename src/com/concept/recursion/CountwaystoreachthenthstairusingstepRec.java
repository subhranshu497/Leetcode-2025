package com.concept.recursion;

import java.util.Arrays;

public class CountwaystoreachthenthstairusingstepRec {
    public static void main(String[] args) {
        int n = 4;
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        int ways = countWaysI(n, memo);
        System.out.println(ways);
    }

    private static int countWaysI(int n, int [] memo) {
        //base case
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 4;
        if(memo[n] !=-1) return memo[n];
        return memo[n]= countWaysI(n-1,memo)+countWaysI(n-2, memo)+countWaysI(n-3, memo);
    }
}
