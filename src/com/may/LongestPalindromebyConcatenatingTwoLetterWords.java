package com.may;

import com.februry.MinimumOperationsToExceedThresholdValueII;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LongestPalindromebyConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        String [] words = {"lc","cl","gg"};
        int length = longestPalindrome(words);
        System.out.println(length);
    }

    private static int longestPalindrome(String[] words) {
        int res = 0;
        Map<String ,Integer> map = new ConcurrentHashMap<>();
        for(String word : words){
            String rev = new StringBuilder(word).reverse().toString();
            if(map.getOrDefault(rev,0)>0){
                res +=4;
                map.put(rev, map.getOrDefault(rev, 0)-1);
            } else {
                map.put(word, map.getOrDefault(word, 0)+1);
            }

        }
        //check for equal char of words
        for(Map.Entry<String, Integer> e:map.entrySet()){
            String word = e.getKey();
            int val = e.getValue();
            if(word.charAt(0)==word.charAt(1) && val >0){
                res +=2;
                break;
            }
        }
        return res;
    }
}
