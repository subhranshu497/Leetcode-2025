package com.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumScoreAfterRemovalsonaTree {
    public static void main(String[] args) {
        int [][] edges = {{0,1},{1,2},{1,3},{3,4}};
        int [] nums = {1,5,5,4,11};
        int score = minimumScore(edges, nums);
        System.out.println(score);
    }

    private static int minimumScore(int[][] edges, int[] nums) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int n = nums.length;
        //lets precompute the xor value for each node
        //assumption root =0
        //also
        int [] subTreeXor = new int [n];
        int [] inTime = new int[n];
        int [] outTime = new int[n];
        int [] timer = new int[n];
        for(int [] edge:edges){
            int u = edge[0];
            int v= edge[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        //do dfs
        minimumScoreDFS(0,-1,subTreeXor,inTime, outTime, timer, nums, adjList);
        //try out each pair of node
        //root =0 , assumption
        int score = Integer.MAX_VALUE;
        for(int u=1;u<n;u++){
            for(int v=u+1;v<n;v++){
                int xor1 = 0;
                int xor2 =0;
                int xor3 =0;
                if(isAncestor(u,v, inTime, outTime)){
                    xor1 = subTreeXor[v];
                    xor2 = subTreeXor[u]^xor1;
                    xor3 = subTreeXor[0]^xor1^xor2;
                }else if(isAncestor(v,u, inTime, outTime)){
                    xor1 = subTreeXor[u];
                    xor2 = subTreeXor[v]^xor1;
                    xor3 = subTreeXor[0]^xor1^xor2;
                }else{
                    xor1 = subTreeXor[u];
                    xor2 = subTreeXor[v];
                    xor3 = subTreeXor[0]^xor1^xor2;
                }
                score = Math.min(score, getScore(xor1, xor2, xor3));
            }
        }
        return score;
    }

    private static int getScore(int a, int b, int c) {
        int maxXor = Integer.MIN_VALUE;
        int minXor = Integer.MAX_VALUE;

        maxXor = Math.max(a, Math.max(b,c));
        minXor = Math.min(a, Math.min(b,c));
        return maxXor-minXor;
    }

    private static boolean isAncestor(int u, int v, int[] inTime, int[] outTime) {
        return inTime[u]<=inTime[v] && outTime[v]<=outTime[u];
    }

    private static void minimumScoreDFS(int u, int parent, int[] subTreeXor, int[] inTime, int[] outTime, int[] timer,int[] nums, Map<Integer, List<Integer>> adjList) {
        subTreeXor[u] = nums[u];
        inTime[u] = timer[0]++;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(v !=parent){
                minimumScoreDFS(v, u, subTreeXor,inTime,outTime,timer,nums,adjList);
                subTreeXor[u] ^=subTreeXor[v];
            }
        }
        outTime[u] = timer[0]++;
    }
}
