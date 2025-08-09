package com.concept;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

   private static int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        String [] words = {"oath","pea","eat","rain"};
        char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        List<String> res = findWords(words, board);
        System.out.println(res);
    }

    private static List<String> findWords(String[] words, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        //construct the trie
        TrieNode root = new TrieNode();
        for (String str :words){
            insert(root, str);
        }
        //run dfs to serch the word
        List<String> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch = board[i][j];
                if(root.children[ch-'a'] !=null)
                    wordSearchIIDFS(board, i,j,n,m,root,res);
            }
        }
        return res;
    }

    private static void wordSearchIIDFS(char[][] board, int i, int j,int n, int m, TrieNode root, List<String> res) {
        //boundary condition
        if(i>=n || j>=m || i<0 || j<0 || board[i][j] == '$')
            return;
        char currentChar = board[i][j];
        int index = currentChar - 'a';
        if(root.children[index]== null)
            return;
        root = root.children[index];
        if(root.endOfWord){
            res.add(root.wordInTrie);
            root.endOfWord = false;
        }
        char temp = board[i][j];
        board[i][j]= '$';
        for(int [] direction:directions){
            int i_ = i+direction[0];
            int j_ = j+direction[1];
            wordSearchIIDFS(board,i_,j_,n,m,root,res);
        }
        board[i][j] = temp;
    }

    //insert into trie
    private static void insert(TrieNode root , String str){
        TrieNode pCrawl = root;
        for(char ch:str.toCharArray()){
            int index = ch-'a';
            if(pCrawl.children[index]==null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.endOfWord = true;
        pCrawl.wordInTrie = str;
    }

}
class TrieNode{
    boolean endOfWord;
    String wordInTrie;
    TrieNode [] children;

    public TrieNode(){
        endOfWord = false;
        wordInTrie = "";
        children = new TrieNode[26];
    }

}
