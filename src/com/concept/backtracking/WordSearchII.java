package com.concept.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int m,n,k;
    public static void main(String[] args) {
        char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        m = board.length;
        n = board[0].length;
        k = words.length;
        List<String> wordList = wordSearchTwo(board, words);
        System.out.println(wordList);
    }

    private static List<String> wordSearchTwo(char[][] board, String[] words) {
        List<String> res= new ArrayList<>();
        for(String word:words){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]==word.charAt(0)){
                        if(checkForWord(board, word,0,i,j)){
                            res.add(word);
                        }
                    }
                }
            }
        }
        return res;
    }

    private static boolean checkForWord(char[][] board, String word, int idx, int i, int j) {
        //base condition
        if(idx>=word.length()) return true;
        //oob
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]=='$')
            return false;
        //if(word.charAt(idx) !=board[i][j]) return false;
        char ch = board[i][j];
        board[i][j] ='$';
        //do the operation
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            if(checkForWord(board,word,idx+1,i_,j_)) return true;
        }
        //backtrack
        board[i][j] = ch;
        return false;
    }
}
