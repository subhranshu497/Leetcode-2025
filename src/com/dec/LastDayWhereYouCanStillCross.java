package com.dec;

public class LastDayWhereYouCanStillCross {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int row = 3, col = 3;
        int [][] cells = {{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}};
        int day = latestDayToCross(row, col, cells);
        System.out.println(day);
    }

    private static int latestDayToCross(int row, int col, int[][] cells) {
        int l = 0;
        int r = cells.length - 1;
        int lastDay = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canCross(cells, mid, row, col)) {
                lastDay = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return lastDay;
    }

    private static boolean canCross(int [][] cells, int day, int row, int col){
        int [][] grid = new int[row][col];
        for(int i=0;i<=day;i++){
            int r = cells[i][0]-1;
            int c = cells[i][1]-1;
            grid[r][c] =1;
        }
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 0 && dfsLastDayToCross(grid, 0, j, row, col)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfsLastDayToCross(int[][] cells, int r, int c, int row, int col) {
        //check out of bound
        if(r>=row || c>=col || r<0 || c<0 || cells[r][c]==1)return false;
        if(r==row-1)return true;
        cells[r][c] =1;

        for(int [] dir:directions){
            int r_ = r+dir[0];
            int c_ = c+dir[1];
            if(dfsLastDayToCross(cells, r_, c_,row, col)) return true;
        }
        return false;
    }
}
