package com.june;

import java.util.*;

public class MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public static void main(String[] args) {
        String s = "abcabcab";
        int res = maxDifference(s);
        System.out.println(res);
    }

    private static int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1);
        Collection<Integer> list = map.values();
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for(int l:list){
            if(l % 2 ==0)
                minEven = Math.min(minEven, l);
            else
                maxOdd = Math.max(maxOdd, l);
        }
        return maxOdd-minEven;
    }
}
