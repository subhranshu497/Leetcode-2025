package com.june;

import java.util.*;

public class LexicographicallySmallestEquivalentString {
    public static void main(String[] args) {
        String s1 = "parker", s2 = "morris", baseStr = "parser";
        String res = smallestEquivalentString(s1, s2, baseStr);
        System.out.println(res);
    }

    private static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        //create adj list
        Map<Character, Set<Character>> adjList = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            adjList.computeIfAbsent(ch1, k->new HashSet<>()).add(ch2);
            adjList.computeIfAbsent(ch2, k->new HashSet<>()).add(ch1);
        }
        System.out.println(adjList);
        StringBuilder sb = new StringBuilder();
        //parse basestr and do dfs for each char
        for(char ch:baseStr.toCharArray()){
            boolean [] visited = new boolean[26];
            char c = dfs2(adjList,visited,ch);
            sb.append(c);
        }
        return sb.toString();
    }

    private static char dfs2(Map<Character, Set<Character>> adjList, boolean[] visited, char ch) {
        //mark visited
        visited[ch-'a']=true;
        System.out.println(ch-'a');
        char minChar = ch;
        //visit the neighbors
        for(char c:adjList.getOrDefault(ch, new HashSet<>())){
            //call dfs
            if(!visited[c-'a']){
                char nextMinChar = dfs2(adjList, visited, c);
                if(nextMinChar<minChar){
                    minChar = nextMinChar;
                }
            }

        }
        return minChar;
    }
}
