package com.july;

import java.util.*;

public class WordAbbreviation {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("like","god","internal","me","internet","interval"
                ,"intension","face","intrusion"));
        List<String> res = wordsAbbreviation(words);
        System.out.println(res);
    }

    private static List<String> wordsAbbreviation(List<String> words) {
        List<String> res= new ArrayList<>();
        Map<String, Trie> map = new HashMap<>();

        for(int i=0;i<words.size();i++){
            String word = words.get(i);
            String key = ""+word.charAt(word.length()-1)+word.length();
            int preLen = map.get(key).searchUniquePrefix(words.get(i));
            if(preLen +2 >=words.get(i).length())
                res.add(words.get(i));
            else res.add(words.get(i).substring(0,preLen)+(words.get(i).length()-preLen-1)
            +words.get(i).charAt(words.get(i).length()-1));
        }
        return res;
    }
}
class Trie{
    Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(String s){
        Node t = root;
        for(char c:s.toCharArray()){
            t.count++;
            if(!t.children.containsKey(c)){
                t.children.put(c, new Node());
            }
            t.children.get(c);
        }
        t.count++;
        t.isLeaf =true;
    }
    public int searchUniquePrefix(String s){
        Node t = root;
        int len =0;
        for(char c:s.toCharArray()){
            t = t.children.get(c);
            len++;
            if(t.count==1)break;
        }
        return len;
    }
}
class Node {
    Map<Character , Node> children;
    boolean isLeaf;
    int count;

    public Node(){
        children = new HashMap<>();
        isLeaf = false;
        count =0;
    }
}

