package com.june;

import com.februry.MinimumOperationsToExceedThresholdValueII;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaximumCandiesYouCanGetFromBoxes {
    public static void main(String[] args) {
        int [] status = {1,1,1};
        int [] candies = {100,1,100};
        int [][] keys = {{},{0,2},{}};
        int [][] containedBoxes = {{},{},{}};
        int [] initialBoxes = {1};
        int collectedCandies = maxCandies(status, candies, keys, containedBoxes,initialBoxes);
        System.out.println(collectedCandies);
    }

    private static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> q= new LinkedList<>();
        boolean[] visited = new boolean[candies.length];
        Set<Integer> foundBoxes = new HashSet<>();
        int candiesCollected =0;
        //start visiting from the initial box array
        for(int box:initialBoxes){
            foundBoxes.add(box);
            if(status[box]==1){
                q.add(box);
                visited[box]=true;
                candiesCollected += candies[box];
            }
        }
        while(!q.isEmpty()){
            int currentBox = q.poll();
            int [] listOfBoxesFromCurrentBox= containedBoxes[currentBox];
            //process list of boxes from current box
            for(int box:listOfBoxesFromCurrentBox){
                foundBoxes.add(box);
                if(status[box]==1){
                    q.add(box);
                    visited[box]=true;
                    candiesCollected +=candies[box];
                }
            }
            //process keys
            int [] listOfKeysInCurrentBox = keys[currentBox];
            for(int k:listOfKeysInCurrentBox){
                status[k] = 1;
                if(foundBoxes.contains(k) && !visited[k]){
                    q.add(k);
                    visited[k]=true;
                    candiesCollected +=candies[k];
                }
            }
        }
        return candiesCollected;
    }
}
