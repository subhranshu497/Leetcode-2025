package com.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimetoReachLastRoomI {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int [][] moveTime = {{0,4},{4,4}};
        int minTime = minimumTimeToReach(moveTime);
        System.out.println(minTime);
    }

    private static int minimumTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int [][] result = new int[m][n];
        for(int [] row:result)
            Arrays.fill(row, Integer.MAX_VALUE);

        //PQ - min heap {time, i, j}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        result[0][0] = 0;
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int [] current = pq.poll();
            int currentTime = current[0];
            int i = current[1];
            int j = current[2];
            //reched destination
            if(i == m-1 && j == n-1) return currentTime;

            for(int [] direction: directions){
                int i_ = i+direction[0];
                int j_ = j+direction[1];

                //check within boundary
                if(i_ >=0 && i_ <m && j_ >=0 && j_ < n){
                    int wait = Math.max(moveTime[i_][j_]-currentTime, 0);
                    int time = currentTime+wait+1;

                    if(result[i_][j_] > time){
                        result[i_][j_] = time;
                        pq.offer(new int[]{time, i_,j_});
                    }
                }
            }
        }
        return -1;
    }
}
