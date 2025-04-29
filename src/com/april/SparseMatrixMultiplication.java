package com.april;

public class SparseMatrixMultiplication {
    public static void main(String[] args) {
        int [][] mat1 = {{1,0,0},{-1,0,3}};
        int [][] mat2 ={{7,0,0},{0,0,0},{0,0,1}};
        int[][] result = multiply(mat1, mat2);
        //print the result
        for(int i=0;i<result.length;i++){
            for(int j=0;j< result[0].length;j++){
                System.out.print(result[i][j]+", ");
            }
            System.out.println();
        }
    }

    private static int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int l = mat1[0].length;
        int n = mat2[0].length;
        int [][] result = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp = 0;
                for(int k=0;k<l;k++){
                    temp += mat1[i][k]*mat2[k][j];
                }
                result[i][j] = temp;
            }
        }
        return result;
    }
}
