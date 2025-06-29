package com.concept.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res);
    }

    private static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, List<Character>> map = initialMap();
        generateResult(0,digits, new StringBuilder(), res, map);
        return res;
    }

    private static void generateResult(int idx, String digits, StringBuilder sb, List<String> res, Map<Character, List<Character>> map) {
        List<Character> charList = new ArrayList<>();
        //get the coresponding value from map
        if(idx<digits.length())
            charList = map.get(digits.charAt(idx));
        //for idx =0, char list = a,b,c
        if(idx >= digits.length()){
            res.add(sb.toString());
            return;
        }

        for(int i=0;i<charList.size();i++){
            sb.append(charList.get(i)); //do
            generateResult(idx+1,digits,sb, res,map); // explore
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }

    private static Map<Character, List<Character>> initialMap() {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('1', new ArrayList<>());
        map.put('2', List.of('a','b','c'));
        map.put('3', List.of('d','e','f'));
        map.put('4', List.of('g','h','i'));
        map.put('5', List.of('j','k','l'));
        map.put('6', List.of('m','n','o'));
        map.put('7', List.of('p','q','r','s'));
        map.put('8', List.of('t','u','v'));
        map.put('9', List.of('w','x','y','z'));
        return map;
    }
}
