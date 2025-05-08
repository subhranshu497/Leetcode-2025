package com.amazon.prep.arraysString;

public class RotateImage {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int [][] result = rotate1(matrix);
        int n = matrix.length;
        //print result
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] rotate1(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i==j)continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //invert the matrix
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j]= temp;
            }
        }

        return matrix;
    }
}
