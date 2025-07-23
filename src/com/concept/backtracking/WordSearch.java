package com.concept.backtracking;

public class WordSearch {

    public static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        char [][] board = {{'a','b'}, {'c','d'}};
        String word ="abcb";
        System.out.println(exist1(board, word));
    }

    private static boolean exist1(char[][] board, String word) {
       for(int i =0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
               if(word.charAt(0)==board[i][j]){
                   //do dfs
                   if(dfsWordSearch(board, word, 0, i,j))
                       return true;
               }
           }
       }
       return false;
    }

    private static boolean dfsWordSearch(char[][] board, String word, int index, int i, int j) {
        //base condition
        if(index>=word.length()) return true;
        //check out of bound
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || board[i][j]=='#')
            return false;
        if(word.charAt(index) != board[i][j])
            return false;
        char ch = board[i][j];
        board[i][j] = '#';
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            if(dfsWordSearch(board, word, index+1,i_,j_))
                return true;
        }
        board[i][j] = ch;
        return false;
    }

}
