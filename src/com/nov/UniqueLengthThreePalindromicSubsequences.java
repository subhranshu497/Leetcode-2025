package com.nov;

import java.util.HashSet;
import java.util.Set;

public class UniqueLengthThreePalindromicSubsequences {
    private static  int count =0;
    public static void main(String[] args) {
        String s = "bbcbaba";
        int count = countPalindromicSubsequence(s);
        System.out.println(count);
    }

    private static int countPalindromicSubsequence(String s) {
        int count =0;
        int n = s.length();
        for(char ch='a';ch<='z';ch++){
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
            if(first !=-1 && last !=-1 && last-first >=2){
                Set<Character> mid = new HashSet<>();
                for(int i = first+1;i<last;i++)
                    mid.add(s.charAt(i));
                count += mid.size();
            }
        }
        return count;
    }

    private static int countPalindromicSubsequenceRec(String s) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        Set<String> memo = new HashSet<>();
        for(int i=0;i<n;i++){
            solveCountPallindromeSub(s,n,i,new StringBuilder(), set, memo);
        }
        return set.size();
    }

    private static void solveCountPallindromeSub(String s, int n, int i, StringBuilder sb, Set<String> set, Set<String> memo) {
        if(sb.length() == 3){
            if(isPallindrome(sb.toString()))set.add(sb.toString());
            return;
        }
        if(i>=n) return;
        String key = i + "|" + sb.toString();
        if (memo.contains(key)) return;
        memo.add(key);
        //do
        char ch = s.charAt(i);
        sb.append(ch);
        solveCountPallindromeSub(s,n, i+1,sb, set, memo);
        sb.deleteCharAt(sb.length()-1);
        solveCountPallindromeSub(s,n,i+1,sb, set,memo);
    }

    private static boolean isPallindrome(String s) {
        if(s.charAt(0)==s.charAt(2))return true;
        return false;
    }

}
