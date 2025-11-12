package com.nov;

public class CountUnguardedCellsintheGrid {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int  m = 4;
        int n = 6;
        int [][] guards = {{0,0},{1,1},{2,3}};
        int [][] walls = {{0,1},{2,2},{1,4}};
        int res = countUnguarded(m,n,guards, walls);
        System.out.println(res);
    }

    private static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] grid = new int[m][n];
        //traversing starts from a guard
        //2 = guard , 3 = wall
        for(int [] guard:guards){
            grid[guard[0]][guard[1]]= 2;
        }
        for(int [] wall:walls){
            grid[wall[0]][wall[1]]= 3;
        }
        for(int [] guard:guards){
            dfsGrid(grid, guard[0]+1,guard[1], m,n,1);
            dfsGrid(grid, guard[0],guard[1]+1, m,n,2);
            dfsGrid(grid, guard[0]-1,guard[1], m,n,3);
            dfsGrid(grid, guard[0],guard[1]-1, m,n,4);
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)res++;
            }
        }
        return res;
    }
    private static void dfsGrid(int[][] grid, int i, int j, int m, int n, int direction) {
        //base condition
        if(i<0 || j>=n || i>=m || j<0 || grid[i][j]==2 || grid[i][j]==3) return;
        grid[i][j] =1;
        if(direction==1) dfsGrid(grid,i+1,j,m,n,direction); // down
        else if(direction==2) dfsGrid(grid,i,j+1,m,n,direction); // right
        else if(direction==3) dfsGrid(grid,i-1,j,m,n,direction); // up
        else if(direction==4) dfsGrid(grid,i,j-1,m,n,direction); // left
    }
}
