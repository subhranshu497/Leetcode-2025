package com.februry;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities {
    public static void main(String[] args) {
        String tiles = "AAB";
        int count = numTilePossibilities(tiles);
        System.out.println(count);
    }

    private static int numTilePossibilities(String tiles) {
        int n = tiles.length();
        Set<String> result = new HashSet<>();
        boolean[] visited = new boolean[n];
        StringBuilder curr = new StringBuilder();
        numTilePossibilitiesSolve(tiles, result, curr, visited, n);

        return result.size()-1;
    }

    private static void numTilePossibilitiesSolve(String tiles, Set<String> result, StringBuilder curr, boolean[] visited, int n) {
            result.add(curr.toString());

            for(int i=0;i<n;i++){
                if(visited[i]) continue;
                visited[i] = true;
                curr = curr.append(tiles.charAt(i));
                numTilePossibilitiesSolve(tiles, result, curr, visited,n);
                //undo
                visited[i] = false;
                curr.deleteCharAt(curr.length()-1);
            }
    }
}
