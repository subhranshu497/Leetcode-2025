package com.graph;

import java.util.*;

public class cycleDetectionACGUsingBFS {
    public static void main(String[] args) {
        int V = 4, E=4;
        int [][] edges = {{0,1},{0,2},{1,2},{2,3}};
        boolean flag = isCycleBFS(edges,V,E);
        System.out.println(flag);
    }

    private static boolean isCycleBFS(int[][] edges, int V, int E) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        boolean [] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(detectCycleInACGBFS(adjList, visited,i,-1))
                    return true;
            }
        }
        return false;
    }

    private static boolean detectCycleInACGBFS(Map<Integer, List<Integer>> adjList, boolean[] visited, int i, int parent) {
        Queue<int[]> q = new LinkedList<>();
        visited[i] = true;
        q.add(new int[]{i,parent});
        while (!q.isEmpty()){
            int [] fromQ = q.poll();
            int u = fromQ[0];
            int parent_=fromQ[1];
            for(int v:adjList.getOrDefault(u, new ArrayList<>())){
                if(v==parent_) continue;
                if(visited[v])return true;
                visited[v] = true;
                q.add(new int[]{v,u});
            }
        }
        return false;
    }
}
