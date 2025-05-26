package com.may;

import java.util.*;

public class LargestColorValueDirectedGraph {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{0,2},{2,3},{3,4}};
        String colors = "abaca";
        int res = largestPathValue(edges, colors);
        System.out.println(res);
    }

    private static int largestPathValue(int[][] edges, String colors) {
        //create adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int N = colors.length();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
        }
        //calculate indegree for each node
        int [] indegree = new int[N];
        for(int u=0;u<N;u++){
            for(int v:adjList.getOrDefault(u, new ArrayList<>())){
                indegree[v]++;
            }
        }
        //since in this qn order is important so use topological sort alogo
        // so start with the node whose indegree is zero
        // also to track the frequency of the largest color use a 2d array
        //dp[node][color] --> dp[N][26] , as the colors can be a..... z
        int [][] dp = new int [N][26];
        //start the topo sort
        Queue<Integer> q = new LinkedList<>();
        //to start the topop sort add all the nodes to the queue whose indegree is zero
        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                q.add(i);
                dp[i][colors.charAt(i)-'a']=1;
            }
        }
        int ans = 0;
        int nodeCount = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            nodeCount++;
            for(int i=0;i<26;i++)
                ans = Math.max(ans, dp[u][i]);
            for(int v :adjList.getOrDefault(u, new ArrayList<>())){
                for(int i=0;i<26;i++){
                    int val = dp[u][i]+(colors.charAt(v)-'a'==i?1:0);
                    dp[v][i] = Math.max(dp[v][i], val);
                }
                indegree[v]--;
                if(indegree[v]==0)
                    q.add(v);
            }
        }
        return nodeCount <N?-1:ans;
    }
}
