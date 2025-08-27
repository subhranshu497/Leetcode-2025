package com.august;

public class LengthofLongestVShapedDiagonalSegment {
    private static int [][] directions = {{1,1},{1,-1},{-1,-1},{-1,1}};
    public static void main(String[] args) {
        int [][] grid = {{0,0,1,0},{0,2,2,0}};
        int res = lenOfVDiagonal(grid);
        System.out.println(res);
    }

    private static int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        //starting point is 1
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int dir=0;dir<4;dir++){
                        res = Math.max(res, 1+solveVshapedDiagonalSegment(i,j,m,n,dir,1,2,grid));
                    }
                  }
            }
        }
        return res;
    }

    private static int solveVshapedDiagonalSegment(int i, int j, int m, int n, int dir, int canTurn, int val, int[][] grid) {
        int i_ = i+directions[dir][0];
        int j_ = j+directions[dir][1];
        //out of bound check
        if(i_<0 || i_>=m || j_<0 || j_>=n)return 0;
        if(grid[i_][j_] !=val)return 0;
        int res = 0;
        int nextVal = val==2?0:2;
        int move = 1+solveVshapedDiagonalSegment(i_,j_,m,n,dir,canTurn,nextVal,grid);
        res = Math.max(res, move);
        int turned =0;
        if(canTurn==1){
             turned = 1+solveVshapedDiagonalSegment(i_,j_,m,n,(dir+1)%4,0,nextVal,grid);
            res = Math.max(res, turned);
        }
        return res;
    }
}
