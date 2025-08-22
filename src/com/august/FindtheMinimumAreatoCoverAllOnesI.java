package com.august;

public class FindtheMinimumAreatoCoverAllOnesI {
    public static void main(String[] args) {
        int [][] grid = {{0,0,0},{0,0,0},{0,0,1}};
        int area = minimumArea(grid);
        System.out.println(area);
    }

    private static int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int area =0;
        //first count all 1s
        int minRow=m;
        int maxRow=-1;
        int minCol=n;
        int maxCol=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) {
                    maxRow = Math.max(maxRow,i);
                    minRow = Math.min(minRow,i);
                    maxCol = Math.max(maxCol,j);
                    minCol = Math.min(minCol,j);
                }
            }
        }

        int w = (maxRow-minRow)+1;
        int h = (maxCol-minCol)+1;
        return w*h;
    }
}
