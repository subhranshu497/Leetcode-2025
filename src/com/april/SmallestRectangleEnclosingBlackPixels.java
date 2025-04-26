package com.april;

public class SmallestRectangleEnclosingBlackPixels {
    private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int m,n, maxi, maxj, mini, minj;
    public static void main(String[] args) {
        char [][] images = {{'0','0','1','0'},{'0','1','1','0'},{'0','1', '0','0'}};
        int x =0;
        int y =2;
        int area = minArea(images, x, y);
        System.out.println(area);
    }

    private static int minArea(char[][] images, int x, int y) {
        m = images.length;
        n = images[0].length;
        boolean[][] visited = new boolean[m][n];
        maxi = mini =x;
        maxj = minj =y;
        solvearea(images, visited, x,y);
        int area = (maxi-mini+1)*(maxj-minj+1);
        return area;
    }

    private static void solvearea(char[][] images, boolean[][] visited, int i, int j) {
        //base condition
        if(i<0 || i>=m || j<0 || j>=n || images[i][j]=='0' || visited[i][j])
            return;
        visited[i][j] =true;
        maxi = Math.max(maxi, i);
        maxj = Math.max(maxj, j);
        mini = Math.min(mini, i);
        minj = Math.min(minj, j);
        for(int [] direction:directions){
            int i_ = direction[0]+i;
            int j_ = direction[1]+j;
            solvearea(images, visited,i_,j_);
        }
    }
}
