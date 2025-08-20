package com.august;

import java.util.Arrays;

public class CountSquareSubmatriceswithAllOnes {
    public static void main(String[] args) {
        int[][] matrix =
                {
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}
                };
        int count = countSquares(matrix);
        System.out.println(count);
    }

    private static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] t = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 || j==0)t[i][j] = matrix[i][j];
                else{
                    if (matrix[i][j] == 1) {
                        t[i][j] = 1 + Math.min(t[i - 1][j], Math.min(t[i][j - 1], t[i - 1][j - 1]));
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += t[i][j];
            }
        }
        return count;
    }
}

//    private static int countSquaresMemo(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int [][] memo = new int[m+1][n+1];
//        for(int [] arr:memo)
//            Arrays.fill(arr ,-1);
//        int res = 0;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                res += solveMatrixForOnes(i,j,m,n,matrix, memo);
//            }
//        }
//        return res;
//    }

//    private static int solveMatrixForOnes(int i, int j, int m, int n, int[][] matrix, int [][] memo) {
//        //check for oob
//        if(i<0 || j<0 || i>=m || j>=n || matrix[i][j]==0) return 0;
//        if(memo[i][j] !=-1) return memo[i][j];
//        int right = solveMatrixForOnes(i,j+1,m,n,matrix,memo);
//        int diagonal = solveMatrixForOnes(i+1,j+1,m,n,matrix, memo);
//        int down = solveMatrixForOnes(i+1, j,m,n, matrix,memo);
//        return memo[i][j]=1+Math.min(right, Math.min(diagonal,down));
//    }

