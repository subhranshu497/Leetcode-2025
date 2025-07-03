package com.concept.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word ="ABCB";
        System.out.println(exist1(board, word));
    }

    private static boolean exist1(char[][] board, String word) {
        int m= board.length;
        int n = board[0].length;
        int [][] directions ={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    if(searchWord(m,n,directions,word,i,j, board,0))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord(int m, int n, int[][] directions, String word, int i, int j, char[][]board, int idx) {

        //check for boundary condition
        if(idx>=word.length()) return true;
        if(i>=m || j>=n || i<0 || j<0 || idx<0 || board[i][j] !=word.charAt(idx))
            return false;
        //traverse the string
        char ch =board[i][j];
        board[i][j] ='#';
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            if(searchWord(m,n,directions,word,i_,j_,board,idx+1))
                return true;
        }
        board[i][j] =ch;
        return false;
    }
}
