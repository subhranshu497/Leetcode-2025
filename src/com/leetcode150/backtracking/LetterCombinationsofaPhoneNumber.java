package com.leetcode150.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {
        String digits = "2";
        List<String> res = letterCombinationsI(digits);
        System.out.println(res);
    }

    private static List<String> letterCombinationsI(String digits) {
        Map<Character, String> letterMap = new HashMap<>();
        letterMap.put('1', "");
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        formCombnationBacktracking(0,letterMap, res, digits, new StringBuilder());
        return res;
    }

    private static void formCombnationBacktracking(int i, Map<Character, String> letterMap, List<String> res, String digit, StringBuilder sb) {
        //base case
        if(i>=digit.length()){
            res.add(sb.toString());
            return;
        }
        String s1 = letterMap.get(digit.charAt(i));
        for(char ch:s1.toCharArray()){
            sb.append(ch); //do
            formCombnationBacktracking(i+1,letterMap,res, digit, sb); //explore
            sb.deleteCharAt(sb.length()-1); // undo
        }
    }
}
