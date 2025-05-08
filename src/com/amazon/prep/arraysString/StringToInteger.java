package com.amazon.prep.arraysString;

import java.util.HashSet;
import java.util.Set;

public class StringToInteger {
    public static void main(String[] args) {
        String s = "-91283472332";
        int str = myAtoi(s);
        System.out.println(str);
    }

    private static int myAtoi(String s) {
        //removal of leading spaces
        int res =0;
        int sign =1;
        int i = 0;
        int n = s.length();
        while(i <n && s.charAt(i)==' ')
            i+=1;
        //check for sign bit
        if(i < n && (s.charAt(i)== '+' || s.charAt(i)=='-')){
            if(s.charAt(i)=='-')
                sign *=-1;
            i +=1;
        }
        //now construct the number
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';
            if(res > (Integer.MAX_VALUE-digit)/10){
                return sign ==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = (res*10)+digit;
            i++;
        }
        return res*sign;
    }

    private static boolean isDigit1(char c) {
        Set<Character> set = Set.of('0','1','2','3','4','5','6','7','8','9');

        return set.contains(c);
    }

    private static boolean isChar(char ch) {
        Set<Character> set = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            set.add(c);
        }
        return set.contains(ch);
    }

}
