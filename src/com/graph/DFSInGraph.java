package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSInGraph {
    public static void main(String[] args) {
        int [][] adj = {{1, 2}, {0, 2}, {0, 1, 3, 4}, {2}, {2}};
        List<Integer> res = dfsOnGraph(adj);
        for(int r:res)
            System.out.print(r+", ");
    }

    private static List<Integer> dfsOnGraph(int[][] adj) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int n = adj.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<adj[i].length;j++)
                adjList.computeIfAbsent(i,k->new ArrayList<>()).add(adj[i][j]);
        }
        System.out.println(adjList);
        boolean [] visited = new boolean[n];
        solveDfs(adjList, visited, 0,res);
        return res;
    }

    private static void solveDfs(Map<Integer, List<Integer>> adjList, boolean[] visited, int u, List<Integer> res) {
        //check for visited
        if(visited[u])return;
        visited[u] = true;
        res.add(u);
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(!visited[v]){
                solveDfs(adjList, visited,v,res);
            }
        }
    }
}
