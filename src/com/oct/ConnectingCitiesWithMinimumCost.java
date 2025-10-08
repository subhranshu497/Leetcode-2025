package com.oct;

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {
    private static int [] parent ;
    private static int [] rank;
    private static int V;

    private void initilizeDSU(int V){
        this.V = V;
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        if (x_parent == y_parent) {
            return;
        }
        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
    public static void main(String[] args) {
        int [][] connections = {{1,2,5},{1,3,6},{2,3,1}};
        int n = 3;
        int minCost = minimumCost(n, connections);
        System.out.println(minCost);
    }

    private static int minimumCost(int n, int[][] connections) {
        //find the minimum spanning tree
        Arrays.sort(connections, (a,b)->a[2]-b[2]);
        int minCost = krushkal(n, connections);
        return minCost;
    }

    private static int krushkal(int n, int[][] connections) {
        int minWt =0;
        int edgeConnectted = 0;
        for(int[] connection:connections){
            int u = connection[0]-1;
            int v = connection[1]-1;
            int wt = connection[2];
            int parent_u = find(u);
            int parent_v = find(v);

            if(parent_u != parent_v){
                union(u,v);
                minWt +=wt;
                edgeConnectted++;
            }
        }
        if(n>0 && edgeConnectted != n-1) return -1;
        return minWt;
    }
}