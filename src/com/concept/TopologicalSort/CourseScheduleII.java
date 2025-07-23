package com.concept.TopologicalSort;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] list = findOrder(numCourses, prerequisites);
        for(int i:list)
            System.out.print(i+", ");
    }

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        //to get the list of order of traversing have to write the topo sort
        //first check for has cycle , true --> return empty array
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] preq:prerequisites){
            int u = preq[1];
            int v = preq[0];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        boolean [] visited = new boolean[numCourses];
        boolean [] inRecursion = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int u=0;u<numCourses;u++){
            if(!visited[u] && hasCycleI(adjList, u, inRecursion, visited, st)){
                return new int[]{};
            }
        }
        //write the topo sort from the stack
        int [] res = new int[numCourses];
        int i =0;
        while (!st.isEmpty()){
            res[i] = st.pop();
            i++;
        }
        return res;
    }

    private static boolean hasCycleI(Map<Integer, List<Integer>> adjList, int u, boolean[] inRecursion, boolean[] visited, Stack<Integer> st) {
        visited[u] = true;
        inRecursion[u] = true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(!visited[v] && hasCycleI(adjList, v, inRecursion,visited, st)){
                return true; // in case of cycle
            }else if(inRecursion[v]) return true;
        }
        st.push(u);
        inRecursion[u] = false;
        return false;
    }
}
