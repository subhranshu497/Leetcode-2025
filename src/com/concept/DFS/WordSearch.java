package com.concept.DFS;

public class WordSearch {
    public static int m, n;
    public static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean flag = exist(board, word);
        System.out.println(flag);
    }

    private static boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0) && wordSearchDFS(board, visited, word,0, i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wordSearchDFS(char[][] board, boolean[][] visited, String word, int idx, int i, int j) {
        //base condition
        if(idx==word.length()) return true;
        if(i <0 || i >= m || j <0 || j>=n || visited[i][j]) return false;
        if(board[i][j] != word.charAt(idx)) return false;
        //mark vistied
        visited[i][j] = true;

        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            if(wordSearchDFS(board, visited, word,idx+1, i_, j_)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
