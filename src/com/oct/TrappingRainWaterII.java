package com.oct;

import java.util.*;

public class TrappingRainWaterII {
    public static void main(String[] args) {
        int [][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        int trappedWater = trapRainWater(heightMap);
        System.out.println(trappedWater);
    }

    private static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean [][] visited = new boolean[m][n];
        int trappedWater = 0;
        //take a priority queue of min heap
        //[0] - height , [1] - x cordinate , [2] - y cordinate
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        //populate the priority queue
        //add the left and right col in pq
        for(int i=0;i<m;i++){
            pq.add(new int []{heightMap[i][0],i,0});
            visited[i][0]  = true;
            pq.add(new int []{heightMap[i][n-1],i,n-1});
            visited[i][n-1]  = true;
        }
        //add the top and bottom row in pq
        for(int j=0;j<n;j++){
            pq.add(new int []{heightMap[0][j],0,j});
            visited[0][j]  = true;
            pq.add(new int []{heightMap[m-1][j],m-1,j});
            visited[m-1][j]  = true;
        }
        int [][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        //traverse the minheap
        while(!pq.isEmpty()){
            int [] arr = pq.poll();
            int height = arr[0];
            int i = arr[1];
            int j = arr[2];
            for(int [] direction:directions){
                int i_ = i+direction[0];
                int j_ = j+direction[1];
                if(notOutOfBound(i_,j_,m,n) && !visited[i_][j_]){
                    trappedWater +=Math.max(height-heightMap[i_][j_],0);
                    pq.add(new int[]{Math.max(height,heightMap[i_][j_]),i_,j_});
                    visited[i_][j_]= true;
                }
            }
        }

        return trappedWater;
    }

    private static boolean notOutOfBound(int i, int j, int m, int n) {
        return i>=0 && i<m && j>=0 && j<n;
    }
}
