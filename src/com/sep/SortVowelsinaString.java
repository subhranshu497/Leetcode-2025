package com.sep;

import java.util.*;

public class SortVowelsinaString {
    public static void main(String[] args) {
        String s = "lEetcOde";
        String t = sortVowels(s);
        System.out.println(t);
    }

    private static String sortVowels(String s) {
        Set<Character> vowelSet = Set.of('A','E','I','O','U','a','e','i','o','u');
        StringBuilder sb = new StringBuilder();
        List<Character> vowelList = new ArrayList<>();
        for(int i=0;i<s.length();i++)
            if(vowelSet.contains(s.charAt(i)))vowelList.add(s.charAt(i));

        Collections.sort(vowelList);
        for(int i=0;i<s.length();i++) {
            if (vowelSet.contains(s.charAt(i))) {
                char vowel = vowelList.getFirst();
                vowelList.removeFirst();
                sb.append(vowel);
            }else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
