package com.march;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheClosestMarkedNode {
    public static void main(String[] args) {
        int n = 4;
        int [][]edges = {{0,1,1},{1,2,3},{2,3,2},{0,3,4}};
        int s = 0;
        int [] marked = {2,3};
        int dist = minimumDistance(n,edges,s,marked);
        System.out.println(dist);
    }

    private static int minimumDistance(int n, int[][] edges, int s, int[] marked) {
        //prepare the adj list;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.putIfAbsent(u,new ArrayList<>());
            adjList.get(u).add(v);
        }
        System.out.println(adjList);
        return 1;
    }
}
