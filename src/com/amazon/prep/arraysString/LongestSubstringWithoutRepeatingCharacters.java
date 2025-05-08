package com.amazon.prep.arraysString;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        int size = longestSubstring(s);
        System.out.println(size);
    }

    private static int longestSubstring(String s) {
        int n = s.length();
        int right =0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        int size =0;
        while(right < n){
            while(right < n && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            size = Math.max(size, set.size());
            set.remove(s.charAt(left));
            left++;
        }
        return size;
    }
}
