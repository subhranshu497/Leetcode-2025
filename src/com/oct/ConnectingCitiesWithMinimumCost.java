package com.oct;

import java.util.*;

public class ConnectingCitiesWithMinimumCost {
    public static void main(String[] args) {
        int [][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        int n = 3;
        int minCost = minimumCost(n, connections);
        System.out.println(minCost);
    }

    private static int minimumCost(int n, int[][] connections) {
        //first create the adj list
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int [] connection:connections){
            int u = connection[0]-1;
            int v = connection[1]-1;
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(new int[]{v, connection[2]});
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(new int[]{u, connection[2]});
        }
        System.out.println(adjList);
        //take a visited array to keep track of the vissited node
        //take the parent array to keep track of the parent
        //take a min heap and sort it as per its wt
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean [] visited = new boolean[n];
        //first push the first node to pq and update its parent is -1 and cost is zero as the cost of travelling from and to the same node
        pq.offer(new int[]{0,0});
        int res = 0;
        int edgeCount =0;
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int u = curr[0];
            int wt = curr[1];
           if(visited[u])continue;
            res +=wt;
            visited[u] = true;
            edgeCount++;
            if(edgeCount==n) break;
            for(int[] vArr:adjList.getOrDefault(u, new ArrayList<>())){
                int v = vArr[0];
                int w = vArr[1];
                if(!visited[v]){
                    pq.offer(new int[]{v,w});
                }
            }
        }
        if(edgeCount < n) return -1;
    return res;
    }
}