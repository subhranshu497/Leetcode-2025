package com.may;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }

    private static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<int[]> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0)
                    set.add(new int[]{i,j});
            }
        }
        for(int [] entry:set){
            int x = entry[0];
            int y = entry[1];
            for(int i=0;i<m;i++){
                if(i==x){
                    for(int j=0;j<n;j++){
                        matrix[i][j]=0;
                    }
                }
            }
            for(int j=0;j<n;j++){
                if(j==y){
                    for(int i=0;i<m;i++){
                        matrix[i][j]=0;
                    }
                }
            }
        }
    }
}
