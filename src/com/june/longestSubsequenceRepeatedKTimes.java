package com.june;

import java.util.LinkedHashMap;
import java.util.Map;

public class longestSubsequenceRepeatedKTimes {
    public static void main(String[] args) {
        String s = "letsleetcode";
        int k = 2;
        String res= longestSubsequenceRepeatedK(s,k);
        System.out.println(res);
    }

    private static String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        System.out.println(map);
    //traverse the string and construct result
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map.getOrDefault(ch,0)>=k){
                int rep = map.getOrDefault(ch,0)/k;
                while(rep>0){
                    sb.append(ch);
                    rep--;
                }

                int val = map.getOrDefault(ch,0)-k;
                if(val<=0)map.remove(ch);
                else map.put(ch, val);
            }
        }
        return sb.toString();
    }
}
