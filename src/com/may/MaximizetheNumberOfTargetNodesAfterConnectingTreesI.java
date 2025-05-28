package com.may;

import java.util.*;

public class MaximizetheNumberOfTargetNodesAfterConnectingTreesI {
    public static void main(String[] args) {
        int [] [] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int [][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int k = 2;
        int [] res = maxTargetNodes(edges1, edges2, k);
        for(int r:res)
            System.out.print(r+" ");
    }

    public static int[] maxTargetNodes(int [][] edges1, int [][] edges2, int k){
        int n = edges1.length+1;
        int [] res = new int[n];
        int m = edges2.length+1;
        //step1 create adjacency list
        Map<Integer, List<Integer>> adjList1 = buildAdjacencyList(edges1);
        System.out.println("adjList1 "+adjList1);

        Map<Integer, List<Integer>> adjList2 = buildAdjacencyList(edges2);
        System.out.println("adjList2 "+adjList2);
        //step 2 - run bfs and calculate the nu,ber of nodes can be visties from each node of edges1 at distance k
        for(int i=0;i<n;i++){
            res[i] = bfs(adjList1, k,n,i);
        }
        System.out.println();
        for(int r:res)
            System.out.print(r+" ");
        //step 3 - find out the node who has max node count at a distance k-1
        //k-1 because, we have already used 1 distance by connecting tree1 with tree 2
        int targetNode =-1;
        int targetCount =0;
        for(int i=0;i<m;i++){
            int tempCount = bfs(adjList2, k-1,m,i);
            if(tempCount > targetCount){
                targetCount = tempCount;
            }
        }
        System.out.println();
        System.out.println("targetCount "+targetCount);
        //step 4 - calculate final result
        for(int i=0;i<n;i++){
            res[i] +=targetCount;
        }
        return res;
    }
    //to create adj list
    public static Map<Integer, List<Integer>> buildAdjacencyList(int [][] edges){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, a-> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, a->new ArrayList<>()).add(u);
        }
        return adjList;
    }
    public static int bfs(Map<Integer, List<Integer>> adjList, int k, int n, int st){
        boolean [] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        visited[st] = true;
        int level = 0;
        int nodeCount =0;
        while(!q.isEmpty() && level <=k){
            int size = q.size();
            while(size >0){
                int u = q.poll();
                nodeCount++;
                for(int v:adjList.getOrDefault(u, new ArrayList<>())){
                    if(!visited[v]){
                        q.add(v);
                        visited[v] =true;
                    }
                }
                size--;
            }
            level++;
        }
        return nodeCount;
    }
}
