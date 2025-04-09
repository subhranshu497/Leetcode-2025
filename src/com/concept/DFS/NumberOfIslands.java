package com.concept.DFS;

public class NumberOfIslands {
    public static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int m ,n;
    public static void main(String[] args) {
        char [][] grid = {{'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}};
        int islandCount = numIslands(grid);
        System.out.println(islandCount);
    }

    private static int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int islands =0;
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    islands++;
                    countIslandDFS(grid, visited,i,j);
                }
            }
        }
        return islands;
    }

    private static void countIslandDFS(char[][] grid, boolean[][] visited, int i, int j) {
        //base conditions
        if(i < 0 || i>= m || j < 0 || j >= n || visited[i][j] || grid[i][j]=='0')return;

        //mark visited
        visited[i][j] =true;

        //traverse
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            countIslandDFS(grid, visited, i_, j_);
        }
    }
}
