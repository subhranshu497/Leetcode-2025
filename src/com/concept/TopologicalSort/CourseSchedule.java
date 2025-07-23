package com.concept.TopologicalSort;

import com.concept.DP.LIS;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] courses = {{0,1},{1,0}};
        int numCourses = 2;
        boolean flag = canFinish(courses, numCourses);
        System.out.println(flag);
    }

    private static boolean canFinish(int[][] courses, int numCourses) {
        //create adj list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] course : courses) {
            int u = course[0];
            int v = course[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        }
        //run a dfs and check the feasibility
        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];
        //if hascycle return false, else return true
        for (int u = 0; u < numCourses; u++) {
            if (!visited[u] && hasCycle(u, visited, adjList, inRecursion)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(int u, boolean[] visited, Map<Integer, List<Integer>> adjList, boolean[] inRecursion) {
        inRecursion[u] = true;
        visited[u] =true;
        for(int v:adjList.getOrDefault(u, new ArrayList<>())){
            if(!visited[v] && hasCycle(v,visited,adjList,inRecursion)) return true;
            else if(inRecursion[v]) return true;
        }
        inRecursion[u] = false;
        return false;
    }


}
