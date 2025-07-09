package com.concept.DP;

import java.util.ArrayList;
import java.util.List;

public class MinimumSumPathTriangleDP {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle
                = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3, 9)));
        triangle.add(new ArrayList<>(List.of(1, 6, 7)));
        int sum = minSumPathDP(triangle);
        System.out.println(sum);
    }

    private static int minSumPathDP(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int [][] dp = new int[n][n];
        //base case
        for(int i=0;i<n;i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[i][j] = triangle.get(i).get(j)+
                        Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
