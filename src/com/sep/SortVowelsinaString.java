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
        Map<Integer, Character> positionOfChar = new TreeMap<>();
        List<Character> vowelList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(vowelSet.contains(s.charAt(i))){
                positionOfChar.put(i,s.charAt(i));
                vowelList.add(s.charAt(i));
            }

        }
        //now take all the vowels and sort those
        Collections.sort(vowelList);
        //now iterate the String and check for vowel if it is not in right position
        //take one from the list and delete that one
        for(int i=0;i<s.length();i++) {
            if (vowelSet.contains(s.charAt(i))) {
                char vowel = vowelList.getFirst();
                vowelList.removeFirst();
                sb.append(vowel);
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
