package com.august;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortMatrixbyDiagonals {
    public static void main(String[] args) {
        int [][] grid = {{1,7,3},{9,8,2},{4,5,6}};
        int [][] res = sortMatrix(grid);
        for(int i=0;i<res.length;i++){
            for(int j=0;j< res.length;j++){
                System.out.print(res[i][j]+", ");
            }
            System.out.println();
        }
    }

    private static int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int [][] res = new int[n][n];
        //for bottom left
        for(int row =0;row<n;row++){
            sortDiagonal(grid,row,0,n, true);
        }
        //for top right
        for(int col=1;col<n;col++){
            sortDiagonal(grid,0,col,n, false);
        }

        return grid;
    }

    private static void sortDiagonal(int[][] grid, int row, int col, int n, boolean isLowerLeft) {
        List<Integer> ds = new ArrayList<>();
        int i = row , j=col;
        while(i <n && j<n){
            ds.add(grid[i][j]);
            i++;
            j++;
        }
        if(isLowerLeft)Collections.sort(ds, Collections.reverseOrder());
        else Collections.sort(ds);
        fillTheGrid(row,col,ds,n,grid);
    }
    private static void fillTheGrid(int i, int j, List<Integer> ds, int n, int [][] grid){
        int k =0;
        while(i<n && j<n){
            grid[i][j]= ds.get(k);
            i++;
            j++;
            k++;
        }
    }

}
