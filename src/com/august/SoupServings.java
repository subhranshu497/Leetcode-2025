package com.august;

import java.util.Arrays;

public class SoupServings {
    public static void main(String[] args) {
        int n = 50;
        double probability = soupServings(n);
        System.out.println(probability);
    }

    private static double soupServings(int n) {
        int [][] servings = {{100,0},{75,25},{50,50},{25,75}};
        //at the beginning soup A has n ml and soup B has also n ml
        double [][] memo = new double[5000][5000];
        for(double [] arr:memo)
            Arrays.fill(arr, -1.0);
        double res = soupServingSolve(servings, n,n,n, memo);
        return res;
    }

    private static double soupServingSolve(int[][] servings, int n, int a, int b, double [][] memo) {
        //base condition
        if(a<= 0 && b<=0) return 0.5;
        //soup A is empty , count it as 1
        if(a <= 0) return 1.0;
        if(b<=0) return 0.0;
        if(n>=5000) return 1.0;
        if(memo[a][b] != -1.0) return memo[a][b];
        double prob = 0.0;
        for(int [] serving:servings){
            int servingA = serving[0];
            int servingB = serving[1];
            int remainingA = a-servingA;
            int remainingB = b-servingB;
            prob += soupServingSolve(servings, n, remainingA, remainingB, memo);
        }
        return memo[a][b] = 0.25*prob;
    }
}
