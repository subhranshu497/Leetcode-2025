package com.may;

import java.util.*;

public class MaximizetheNumberOfTargetNodesAfterConnectingTreesII {
    public static void main(String[] args) {
        int [][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int [][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int[] res =  maxTargetNodesII(edges1, edges2);
        for(int r :res)
            System.out.print(r+", ");
    }

    private static int[] maxTargetNodesII(int[][] edges1, int[][] edges2) {
        int n = edges1.length+1;
        int m = edges2.length+1;
        //step-1 - create adjacency list
        Map<Integer, List<Integer>> adjList1 = buildAdjacencyListII(edges1);
        System.out.println(adjList1);
        Map<Integer, List<Integer>> adjList2 = buildAdjacencyListII(edges2);
        System.out.println(adjList2);
        // step -2 - do DFS and mark the nodes 0-even, 1-odd alternatively
        //DFS can be start from any node
        int [] marker1 = new int[n];
        //since we are using 0 as a marker, so fill the array with -1 at start
        Arrays.fill(marker1,-1);
        marker1[0] =0;

        //to avoid infinite recursion pass parent as -1
        dfsI(adjList1,marker1,-1,0);
        System.out.println("Printing marker1 after first dfs");
        for(int r:marker1)
            System.out.print(r+", ");
        System.out.println();
        int zeroCount1=0;
        int oneCount1=0;
        for(int r:marker1){
            if(r==0)zeroCount1++;
            else oneCount1++;
        }
        System.out.println("Zero count "+zeroCount1);
        System.out.println("One Count "+oneCount1);
        //form the nodeCount1 array based on the marker
        int [] nodeCount1 = new int[n];
        for(int i=0;i<n;i++){
            if(marker1[i]==0)
                nodeCount1[i]= zeroCount1;
            else nodeCount1[i] = oneCount1;
        }
        System.out.println("Printing nodecount1 after first dfs");
        for(int r:nodeCount1)
            System.out.print(r+", ");
        System.out.println();
        //step -3 - do the same as step 2 as keep track of max count between zeros and ones
        //DFS can be start from any node
        int [] marker2 = new int[m];
        marker1[0] =0;
        //since we are using 0 as a marker, so fill the array with -1 at start
        Arrays.fill(marker2,-1);
        //to avoid infinite recursion pass parent as -1
        dfsI(adjList2,marker2,-1,0);
         int zeroCount2=0;
        int oneCount2=0;
        for(int r:marker2){
            if(r==0)zeroCount2++;
            else oneCount2++;
        }
        System.out.println("Zero count "+zeroCount2);
        System.out.println("One Count "+oneCount2);
        int maxNodeCountFromTree2 = Math.max(zeroCount2, oneCount2);
        System.out.println(maxNodeCountFromTree2);

        for(int i=0;i<n;i++){
            nodeCount1[i] += maxNodeCountFromTree2;
        }
        return nodeCount1;
    }

    private static void dfsI(Map<Integer, List<Integer>> adjList, int[] marker, int parent, int u) {

        for(int v: adjList.getOrDefault(u, new ArrayList<>())){
            //check for infinite recursion
            if(v !=parent){
                marker[v] = marker[u]==0?1:0;
                dfsI(adjList, marker, u,v);
            }
        }
    }

    private static Map<Integer, List<Integer>> buildAdjacencyListII(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int [] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        return adjList;
    }
}
