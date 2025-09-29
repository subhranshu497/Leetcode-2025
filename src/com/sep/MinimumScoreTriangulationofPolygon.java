package com.sep;

import java.util.Arrays;

public class MinimumScoreTriangulationofPolygon {
    public static void main(String[] args) {
        int [] values = {3,7,4,5};
        int score = minScoreTriangulation(values);
        System.out.println(score);
    }

    private static int minScoreTriangulation(int[] values) {
        int n = values.length;
        int [][] t = new int[51][51];
        for(int [] a:t)
            Arrays.fill(a,-1);
        int result = solveMinScore(values, 0,n-1,n,t);
        return result;
    }

    private static int solveMinScore(int[] values, int i, int j, int n, int [][]t) {
        if(j-i <= 1) return 0;
        if(t[i][j] !=-1) return t[i][j];
        int result = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int score =solveMinScore(values,i,k,n,t)+ values[i]*values[j]*values[k]
                    + solveMinScore(values, k, j,n, t);
            result = Math.min(result, score);
        }
        return t[i][j]=result;
    }
}
