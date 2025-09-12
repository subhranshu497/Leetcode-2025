package com.sep;

import java.util.Set;

public class VowelsGameinaString {
    public static void main(String[] args) {
        String s = "ifld";
        boolean flag = doesAliceWin(s);
        System.out.println(flag);
    }

    private static boolean doesAliceWin(String s) {
        Set<Character> vowelSet = Set.of('a','e','i','o','u');
        //count total number of vowels
        int vowelCount =0;
        for(char ch:s.toCharArray()){
            if(vowelSet.contains(ch))vowelCount++;
        }
        if(vowelCount==0) return false;
        return true;
    }
}
