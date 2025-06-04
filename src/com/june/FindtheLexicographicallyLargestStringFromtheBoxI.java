package com.june;

import java.util.*;

public class FindtheLexicographicallyLargestStringFromtheBoxI {
    public static void main(String[] args) {
        String word = "gh";
        int numFriends = 1;
        String str = answerString(word, numFriends);
        System.out.println(str);
    }

    private static String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) {
            return word;
        }
        List<String> list = new ArrayList<>();
        //first find the max possible length of largest substring
        //in greedy way, give one char each to other friend and keep rest for me
        int maxLen = n-(numFriends-1);
        String res ="";
        //step-2 - traverse and form the string and put in list
        for(int i=0;i<n;i++){
            int endI = Math.min(maxLen, (n-i));
            String str = word.substring(i,i+endI);
            if(str.compareTo(res)>0)res = str;
        }

        return res;
    }
}
