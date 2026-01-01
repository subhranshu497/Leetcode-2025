package com.dec;

public class CountNegativeNumbersinaSortedMatrix {
    public static void main(String[] args) {
        int [][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int count = countNegatives(grid);
        System.out.println(count);
    }

    private static int countNegatives(int[][] grid) {
        int m = grid.length;
        int row = m-1;
        int n = grid[0].length;
        int col = 0;
        int res = 0;
        while(row >= 0 && col <n){
            if(grid[row][col] < 0){
                res +=n-col;
                row--;
            }else {
                col++;
            }
        }
        return res;
    }

    private static int binarySearchForFirstNegative(int[] row) {
        int idx = row.length;
        int l = 0;
        int r = row.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if(row[mid]<0){
                r = mid-1;
                idx = mid;
            }else l = mid+1;
        }
        return idx;
    }

}
