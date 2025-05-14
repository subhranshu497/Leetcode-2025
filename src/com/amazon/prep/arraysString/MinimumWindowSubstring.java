package com.amazon.prep.arraysString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s,t);
        System.out.println(result);
    }

    private static String minWindow(String s, String t) {
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        int count =0;
        for(char ch:t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
            count++;
        }

        int left =0;
        int right=0;
        int n = s.length();
        int windowSize =Integer.MAX_VALUE;
        int start =-1;
        int end =-1;
        while(right <n){
            char rch = s.charAt(right);
            int rVal = map.getOrDefault(rch,0);
            if(map.containsKey(rch) && map.get(rch) >0){
                count--;
            }
            map.put(rch, map.getOrDefault(rch,0)-1);
            //shrink the window
            while(count ==0){
                char lch = s.charAt(left);
                map.put(lch, map.getOrDefault(lch,0)+1);
                int currentWindowSize = right-left+1;
                if(windowSize > currentWindowSize){
                    windowSize = currentWindowSize;
                    start =left;
                }
                if(map.containsKey(lch) && map.get(lch) >0){
                    count++;
                }
                left++;
            }
            right++;
        }
        if(windowSize==Integer.MAX_VALUE)
            return "";
        return s.substring(start, start+windowSize);
    }
}
