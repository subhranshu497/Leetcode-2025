package com.concept.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNthRowOfPascalTriangle {
    public static void main(String[] args) {
        int n =0;
        List<Integer> row = getRow(n);
        System.out.println(row);
    }

    private static List<Integer> getRow(int n) {
        List<Integer> list = new ArrayList<>();
//        if(n==0) {
//            list.add(1);
//            return list;
//        }
        //first form pascal triangle
        int [][] dp = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            dp[i] = new int[i+1];
            Arrays.fill(dp[i], 1);
            for(int j =1;j<i;j++){
                dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
            }
        }
        int [] a = dp[n];
        for(int i:a){
            list.add(i);
        }
        return list;
    }
}
