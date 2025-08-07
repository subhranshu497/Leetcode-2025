package com.august;

import java.util.Arrays;
import java.util.Map;

public class FindtheMaximumNumberofFruitsCollected {
    public static void main(String[] args) {
        int [][] fruits = {{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}};
        int res = maxCollectedFruits(fruits);
        System.out.println(res);
    }

    private static int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int total = 0;
        int [][] memo = new int[n+1][n+1];
        for(int [] arr:memo)
            Arrays.fill(arr, -1);
        //child 1
        for(int i=0;i<n;i++){
            total +=fruits[i][i];
            //since ch 1 collected all the fruits , so mark them as 0
            fruits[i][i] =0;
            memo[i][i] =0;
        }
        //now calculate for child 2

        //now do dfs
        total += child2Dfs(n,memo, fruits,0,n-1);
        //now calculate for child 3
        total +=child3Dfs(n, memo,fruits,n-1,0);

        return total;
    }

    private static int child3Dfs(int n, int[][] memo, int[][] fruits, int i, int j) {
        //base condition
        if (i < 0 || j < 0 || i >= n || j >= n) return 0;
        //since diagonal is already collected by ch 1
        if(i==n-1 && j==n-1) return 0;
        //cant go beyond diagonal && right to diagonal
        if(i==j || j>i) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        int upRight = fruits[i][j]+child3Dfs(n,memo,fruits,i-1,j+1);
        int right = fruits[i][j]+child3Dfs(n,memo,fruits,i,j+1);
        int bottomRight = fruits[i][j]+child3Dfs(n,memo,fruits,i+1,j+1);

        return memo[i][j] = Math.max(upRight, Math.max(right, bottomRight));
    }

    //i=0, j =2
    private static int child2Dfs(int n, int[][] memo, int[][] fruits, int i, int j) {
        //base condition
        if (i < 0 || j < 0 || i >= n || j >= n) return 0;
        //since diagonal is already collected by ch 1
        if(i==n-1 && j==n-1) return 0;
        //cant go below diagonal && left to diagonal
        if(i==j || i>j) return 0;
        if(memo[i][j] != -1) return memo[i][j];

        int bottomLeft = fruits[i][j]+child2Dfs(n,memo,fruits,i+1,j-1);
        int bottomDown = fruits[i][j]+child2Dfs(n,memo,fruits,i+1,j);
        int bottomRight = fruits[i][j]+child2Dfs(n,memo,fruits,i+1,j+1);


        return memo[i][j] = Math.max(bottomDown, Math.max(bottomLeft, bottomRight));

    }
}
