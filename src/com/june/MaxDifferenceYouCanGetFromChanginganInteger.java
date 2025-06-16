package com.june;

import com.februry.MinimumOperationsToExceedThresholdValueII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxDifferenceYouCanGetFromChanginganInteger {
    public static void main(String[] args) {
        int num = 555;
        int res = maxDiff(num);
        System.out.println(res);
    }

    private static int maxDiff(int num) {
       String s = String.valueOf(num);
       Set<Character> set = new HashSet<>();
       for(char ch:s.toCharArray())
           set.add(ch);

       int max = num , min = num;

       for(char digit:set){
           for(char ch='0';ch<='9';ch++){
               if(s.charAt(0)==digit && ch=='0')continue;
               String newS = s.replace(digit, ch);
               int newNum = Integer.parseInt(newS);
               max = Math.max(max, newNum);
               min = Math.min(min, newNum);
           }
       }
       return max-min;
    }
}
