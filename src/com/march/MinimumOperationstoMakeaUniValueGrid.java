package com.march;

import java.util.Arrays;

public class MinimumOperationstoMakeaUniValueGrid {
    public static void main(String[] args) {
        int [][] grid = {{146}};
        int x = 86;
        int ops = minOperations1(grid, x);
        System.out.println(ops);
    }

    private static int minOperations1(int[][] grid, int x) {
        int [] arr = new int[grid.length*grid[0].length];
        int k=0;
        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[k]=grid[i][j];
                k++;
            }
        }
        Arrays.sort(arr);
        for(int num:arr)
            System.out.print(num+", ");
        int n = arr.length;
        System.out.println();
        int target = arr[n/2];
        System.out.println(target);
        int ops = 0;
        for(int i=0;i<n;i++){
            if(arr[i]%x != target % x) return -1;
            else{
                int temp = Math.abs(target-arr[i])/x;
                ops +=temp;
            }
        }
        return ops;
    }
}
