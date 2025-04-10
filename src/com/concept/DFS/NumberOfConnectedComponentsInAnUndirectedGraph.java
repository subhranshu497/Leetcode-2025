package com.concept.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public static void main(String[] args) {
        int [][] edges = {{1,2},{2,3},{3,1}};
        int n =4;
        int components = countComponents(edges, n);
        System.out.println(components);
    }

    private static int countComponents(int[][] edges, int n) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // prepare adj list
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        boolean [] visited = new boolean[n];
        int count =0;
        //start traversing
        for(int u=0;u<n;u++){
            if(adjList.containsKey(u)){
                for(int destList: adjList.get(u)){
                    if(!visited[u]){
                        dfs(adjList, visited,u, n);
                        count++;
                    }
                }
            }else count++;
        }
        return count;
    }

    private static void dfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int u, int n) {
        //base condition
        if(u>=n || visited[u]) return;
        //mark visited
        visited[u] = true;
        for(int v:adjList.get(u)){
            dfs(adjList, visited, v, n);
        }
    }
}
