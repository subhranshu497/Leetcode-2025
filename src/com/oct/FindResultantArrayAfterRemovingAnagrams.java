package com.oct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindResultantArrayAfterRemovingAnagrams {
    public static void main(String[] args) {
        String [] words = {"a","b","c","d","e"};
        List<String> res = removeAnagrams(words);
        System.out.println(res);
    }

    private static List<String> removeAnagrams(String[] words) {
        int i = 0;
        int j =1;
        List<String> res = new ArrayList<>();
        while (j<words.length){
            if(!isAnagram(words[i], words[j])){
                res.add(words[i]);
                i =j;
            }
            j++;
        }
        res.add(words[i]);
        return res;
    }

    private static boolean isAnagram(String word, String word1) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        for(char ch:word.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(char ch:word1.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch,0)+1);
        }
        if(map.size() != map1.size()) return false;
        for(Map.Entry<Character, Integer> e:map.entrySet()){
            char key = e.getKey();
            int val = e.getValue();
            if(!map1.containsKey(key)) return false;
            else{
                int val1 = map1.get(key);
                if(val !=val1) return false;
                map1.remove(key);
            }
        }
        return map1.isEmpty()?true:false;
    }
}
