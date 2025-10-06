package com.oct;

public class SwiminRisingWater {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int [][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        int res = swimInWater(grid);
        System.out.println(res);
    }

    private static int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = grid[0][0];
        int r = (n*n)-1;
        int res =0;
        while (l<=r){
            int mid = l+(r-l)/2;
            boolean [][] visited = new boolean[n][n];
            if(canSwimPossible(grid,0,0, n, mid,visited)){
                r = mid-1;
                res = mid;
            }else l = mid+1;
        }
        return res;
    }

    private static boolean canSwimPossible(int[][] grid, int i, int j, int n, int mid, boolean[][] visited) {
        //check out of bound
        if(i<0 || i>=n || j<0 || j>=n || visited[i][j] || grid[i][j] > mid)
            return false;
        visited[i][j] = true;
        if(i==n-1 && j==n-1) return true;
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            if(canSwimPossible(grid, i_,j_,n,mid,visited)) return true;
        }
        return false;
    }
}
