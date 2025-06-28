package com.concept;

import java.util.*;

public class MinimumTimetoCollectAllApplesinaTree {
    public static void main(String[] args) {
        int n = 7;
        int [][] edges  = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        boolean [] hasApple = {false,false,true,false,true,true,false};
        int time = minTime(edges, hasApple,n);
        System.out.println(time);
    }

    private static int minTime(int[][] edges, boolean[] hasApple, int n) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        int time = collectAppleDfs(adjList, 0,-1, hasApple);
        return time;
    }

    private static int collectAppleDfs(Map<Integer, List<Integer>> adjList, int curr, int parent, boolean[] hasApple) {
        int time =0;
        //traverse through the adj list and go to depth
        for(int child:adjList.getOrDefault(curr, new ArrayList<>())){
            if(child==parent)continue;
            int timeFromChild = collectAppleDfs(adjList, child, curr, hasApple);
            //now check for apple
            if(timeFromChild>0 || hasApple[child]){
                time +=timeFromChild+2;
            }
        }
        return time;
    }
}
