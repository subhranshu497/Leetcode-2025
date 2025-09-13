package com.sep;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FindMostFrequentVowelandConsonant {
    public static void main(String[] args) {
        String s = "successsss";
        int sum = maxFreqSum(s);
        System.out.println(sum);
    }

    private static int maxFreqSum(String s) {
        Set<Character> vowelSet = Set.of('a','e','i','o','u');
        Map<Character, Integer> vowelMap = new HashMap<>();
        Map<Character, Integer> conMap = new HashMap<>();
        for(char ch:s.toCharArray()){
            if(vowelSet.contains(ch)){
                vowelMap.put(ch, vowelMap.getOrDefault(ch,0)+1);
            }else conMap.put(ch, conMap.getOrDefault(ch,0)+1);
        }
        int maxFreqV=0;
        int maxFreqC=0;

        for(Map.Entry<Character, Integer> e:vowelMap.entrySet()){
            int val = e.getValue();
            maxFreqV = Math.max(val, maxFreqV);
        }
        for(Map.Entry<Character, Integer> e:conMap.entrySet()){
            int val = e.getValue();
            maxFreqC = Math.max(val, maxFreqC);
        }
        return maxFreqV+maxFreqC;
    }
}
