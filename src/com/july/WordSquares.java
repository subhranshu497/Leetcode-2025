package com.july;

import java.util.*;

public class WordSquares {
    public static void main(String[] args) {
        String [] words = {"area","lead","wall","lady","ball"};
        List<List<String>> res = wordSqrs(words);
        System.out.println(res);
    }

    private static List<List<String>> wordSqrs(String[] words) {
        List<List<String>> res = new ArrayList<>();
        //step 1 - generate all the prefix for the word
        Map<String, List<String>> prefixTree = new HashMap<>();
        for(String word : words){
            for(int i=1;i<=word.length();i++){
                String sub = word.substring(0,i);
                prefixTree.computeIfAbsent(word, k->new ArrayList<>()).add(sub);
            }
        }

        return res;
    }
}
