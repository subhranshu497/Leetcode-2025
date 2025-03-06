package com.prep;

import java.util.ArrayList;
import java.util.List;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int [][] grid = {{1,3},{2,2}};
        int [] res = findMissingAndRepeatedValues(grid);
        for(int num:res)
            System.out.print(num+", ");
    }

    private static int[] findMissingAndRepeatedValues(int[][] grid) {
        int size = grid.length* grid.length;
        int [] flatArray = new int[size];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid.length;j++){
                if(flatArray[grid[i][j]-1] != 0){
                    res.add(grid[i][j]);
                }else {
                    flatArray[grid[i][j]-1] = grid[i][j];
                }
            }
        }// 1,2,3

        for(int i=0;i<size;i++){
            if(flatArray[i]==0)
                res.add(i+1);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
