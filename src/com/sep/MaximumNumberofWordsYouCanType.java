package com.sep;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofWordsYouCanType {
    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters ="ad";
        int count = canBeTypedWords(text, brokenLetters);
        System.out.println(count);
    }

    private static int canBeTypedWords(String text, String brokenLetters) {
        int count =0;
        Set<Character> set = new HashSet<>();
        for(char ch:brokenLetters.toCharArray()){
            set.add(ch);
        }
        String [] textArr = text.split(" ");
        for(String s:textArr){
            char [] sCharArr = s.toCharArray();
            boolean flag = true;
            for(int i=0;i<sCharArr.length;i++){
                if(set.contains(sCharArr[i])){
                    flag = false;
                    break;
                }
            }
            if(flag)count++;
        }
        return count;
    }
}
