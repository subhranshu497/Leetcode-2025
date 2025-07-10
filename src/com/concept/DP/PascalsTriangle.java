package com.concept.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int numRows =2;
        //List<List<Integer>> res = generatePascalTriangle(numRows);
        generatePascalTriangleSolve(numRows);
    }

    private static List<List<Integer>> generatePascalTriangle(int n) {
        List<List<Integer>> pascalTriangle= new ArrayList<>();
        generatePascalTriangleSolve(n);
        return pascalTriangle;
    }

    private static void generatePascalTriangleSolve(int n) {
        int [][] dp = new int[n][n];
        //from third row onwards
        for(int i = 0;i<n;i++){
            dp[i] = new int[i+1];
            Arrays.fill(dp[i], 1);
            for(int j=1;j<i;j++){
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j] ;
            }
        }
        //convert it to list of list
        List<List<Integer>> res= new ArrayList<>();
        for(int []a:dp){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<a.length;i++){
                list.add(a[i]);
            }
            res.add(list);
        }
        System.out.println(res);

    }
}
