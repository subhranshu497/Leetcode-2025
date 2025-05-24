package com.may;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public static void main(String[] args) {
        String [] words = {"abc","bcd","aaaa","cbc"};
        char x = 'a';
        List<Integer> result = findWordsContaining(words, x);
        System.out.println(result);
     }

    private static List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            char [] charArr = words[i].toCharArray();
            for(char ch:charArr){
                if(ch==x){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}
