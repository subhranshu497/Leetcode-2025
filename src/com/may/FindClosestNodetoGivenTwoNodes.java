package com.may;

import java.util.*;

public class FindClosestNodetoGivenTwoNodes {
    public static void main(String[] args) {
        int [] edges = {2,2,3,-1};
        int node1 = 0;
        int node2 = 1 ;
        int dist = closestMeetingNode(edges, node1, node2);
        System.out.println(dist);
    }

    private static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distance1= new int [n];
        int[] distance2 = new int[n];
        Arrays.fill(distance1, Integer.MAX_VALUE);
        Arrays.fill(distance2, Integer.MAX_VALUE);
        boolean [] visited1 = new boolean[n];
        boolean [] visited2 = new boolean[n];
        distance1[node1] =0;
        distance2[node2] =0;
        //now do dfs and calculate the distance from node1 and another dfs call to calculate distance from node2
        dfsII(edges, distance1,visited1,node1);
        dfsII(edges, distance2,visited2, node2);
        //calculate the minimum distance
        int minDistance =Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<n;i++){
            if(distance1[i] !=Integer.MAX_VALUE && distance2[i] != Integer.MAX_VALUE){
                int maxDistance = Math.max(distance1[i], distance2[i]);

                if(minDistance > maxDistance){
                    minDistance = maxDistance;
                    minIndex =i;
                }
            }
        }
        return minIndex;
    }

    private static void dfsII(int[] edges, int[] distance, boolean[] visited, int u) {
        //mark as visited
        visited[u] =true;
        // here for loop is not needed as each node has at most one outgoing edges
        int v = edges[u];
        if(v !=-1 && !visited[v]){
            distance[v] = 1+distance[u];
            dfsII(edges, distance, visited, v);
        }
    }

    private static void bfsII(int[] edges, int[] distance, boolean [] visited, int u){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        //distance from 0 to 0
        distance[u] =0;
        visited[u] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            int v = edges[curr];
            if(v !=-1 && !visited[v]){
                distance[v] = 1+distance[u];
                q.add(v);
                visited[v] = true;
            }
        }
    }


}
