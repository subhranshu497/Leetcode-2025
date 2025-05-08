package com.may;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomII {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int [][] moveTime = {{0,0,0,0},{0,0,0,0}};
        int minTime = minTimeToReach(moveTime);
        System.out.println(minTime);
    }

    private static int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int [][] result = new int[m][n];
        for(int [] arr:result)
            Arrays.fill(arr, Integer.MAX_VALUE);
        //define a min heap to store time, i,j
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        pq.offer(new int []{0,0,0});

        while(!pq.isEmpty()){
            int[] currentItem = pq.poll();
            int currentTime = currentItem[0];
            int i = currentItem[1];
            int j = currentItem[2];
            if(i== m-1 && j== n-1) return currentTime;
            // check for boundary
                for(int [] direction :directions){
                    int i_ = i+direction[0];
                    int j_ = j+direction[1];

                    if(i_>=0 && i_ < m && j_>=0 && j_ <n){
                        int waitTime = Math.max(moveTime[i_][j_]-currentTime, 0);
                        int cost = (i_+j_)%2==0?2:1;
                        int totalTime = waitTime+currentTime+cost;
                        if(result[i_][j_] > totalTime){
                            result[i_][j_] = totalTime;
                            pq.offer(new int[]{totalTime, i_, j_});
                        }
                    }
                }

        }
        return -1;
    }
}
