package com.amazon.prep.arraysString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchSubsequence {
    public static void main(String[] args) {
        String [] words = {"a", "bb", "acd", "ace"};
        String s = "abcde";
        int count = subsequenceMatcher(words, s);
        System.out.println(count);
    }

    //run into tle
    private static int subsequenceMatcher(String[] words, String s) {
        int count =0;
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for(String word:words)
            map.put(word, map.getOrDefault(word, 0)+1);
        for(String word:map.keySet()){
            int i=0;
            int j=0;
            StringBuilder sb = new StringBuilder();
            while (j<n && i<word.length()){
                if(s.charAt(j)==word.charAt(i)){
                    i++;
                }
                j++;
            }
            if(i==word.length())
                count +=map.get(word);
        }
        return count;
    }
}
