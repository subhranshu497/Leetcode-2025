package com.nov;

import java.util.*;

public class PowerGridMaintenance {
    public static void main(String[] args) {
        int c = 5;
        int [][] connections = {{1,2},{2,3},{3,4},{4,5}};
        int [][] queries = {{1,3},{2,1},{1,1},{2,2},{1,2}};
        int [] res = processQueries(c, connections, queries);

        for(int r:res)
            System.out.print(r+", ");
    }

    private static int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> offlineGrid = new HashSet<>();
        for(int [] connection:connections){
            int u = connection[0];
            int v = connection[1];
            adjList.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }
        //start the preprocessing
        boolean [] visited = new boolean[c+1];
        int [] comp = new int[c+1];
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        //start dfs
        for(int i=1;i<=c;i++){
            if(!visited[i]){
                int statioId = i;
                powerGridDfs(statioId,adjList,i,map,visited,comp, offlineGrid);
            }
        }
        for(int [] query:queries){
            int type = query[0];
            int node = query[1];
            if(type==1){
                int id = comp[node];
                if(map.get(id).contains(node))
                    list.add(node);
                else if(!map.get(id).isEmpty())
                    list.add(map.get(id).first());
                else list.add(-1);
            }else {
                int id = comp[node];
                map.get(id).remove(node);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void powerGridDfs(int statioId, Map<Integer, List<Integer>> adjList, int i, Map<Integer, TreeSet<Integer>> map, boolean[] visited, int[] comp, Set<Integer> offlineGrid) {
        visited[i]=true;
        //map.put(statioId, new TreeSet<>()).add(i);
        map.computeIfAbsent(statioId, k-> new TreeSet<>()).add(i);
        comp[i] = statioId;
        for(int v:adjList.getOrDefault(i, new ArrayList<>())){
            if(!visited[v]){
                powerGridDfs(statioId, adjList,v,map,visited,comp,offlineGrid);
            }
        }
    }
}
