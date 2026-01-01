package com.dec;

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {
    public static void main(String[] args) {
        int [][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        int count = numMagicSquaresInside(grid);
        System.out.println(count);
    }

    private static int numMagicSquaresInside(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int res =0;
        boolean check = false;
        //check for row sum
        for(int i=0;i<=rowLen-3;i++){
            for(int j=0;j<=colLen-3;j++){
                check = calculateRowSum(grid, i,j);
                if(check){
                    res++;
                    //set = new HashSet<>();
                }
            }
        }
        return res;
    }
    private static boolean calculateRowSum(int [][] grid, int rowSt, int colSt){
        Set<Integer> numSet = new HashSet<>();
        //first check the distinct element
        for(int i =rowSt;i<rowSt+3;i++){
            for(int j=colSt;j<colSt+3;j++){
                if(grid[i][j]==0 || grid[i][j]>9 || !numSet.add(grid[i][j]))return false;
            }
        }
        if(numSet.size() != 9) return false;
        Set<Integer> set = new HashSet<>();
        //row sum check
        int rowSum = 0;
        for(int i=rowSt;i<rowSt+3;i++){
            rowSum +=grid[i][colSt]+grid[i][colSt+1]+grid[i][colSt+2];
            set.add(rowSum);
            if(set.size()>1) return false;
        }
        //col sum check
        int colSum = 0;
        for(int i=colSt;i<colSt+3;i++){
            colSum +=grid[rowSt][i]+grid[rowSt+1][i]+grid[rowSt+2][i];
            set.add(colSum);
            if(set.size()>1) return false;
        }
        //check diagonal from left to righ
        int diagonalLRSum = grid[rowSt][colSt]+grid[rowSt+1][colSt+1]+grid[rowSt+2][colSt+2];
        int diagonalRLSum = grid[rowSt][colSt+2]+grid[rowSt+1][colSt+1]+grid[rowSt+2][colSt];
        set.add(diagonalLRSum);
        set.add(diagonalRLSum);
        if(set.size()>1) return false;
        return set.size()==1;
    }
}
