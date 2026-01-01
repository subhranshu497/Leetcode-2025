package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDetectionInUndirectedGraph {
    public static void main(String[] args) {
        int V = 4, E=4;
        int [][] edges = {{0,1},{0,2},{1,2},{2,3}};
        boolean flag = isCycle(edges,V,E);
        System.out.println(flag);
    }

    private static boolean isCycle(int[][] edges, int V, int E) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        //call dfs to check cycle
        boolean [] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i])
                if(detectCyleACGDFS(adjList, i, -1, visited)) return true;
        }
        return false;
    }

    private static boolean detectCyleACGDFS(Map<Integer, List<Integer>> adjList, int u, int parent, boolean[] visited) {
        visited[u] = true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(v==parent) continue;
            if(visited[v])return true;
            if(detectCyleACGDFS(adjList,v,u,visited))return true;
        }
        return false;
    }
}
