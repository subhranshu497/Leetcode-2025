package com.june;

import java.util.Stack;

public class UsingaRobottoPrinttheLexicographicallySmallestString {
    public static void main(String[] args) {
        String s = "bdda";
        String p = robotWithString(s);
        System.out.println(p);
    }

    private static String robotWithString(String s) {
        int n = s.length();
        //preprocess the string and find the smallest char and store in an array
        char [] smallestCharToRight = new char[n];
        smallestCharToRight[n-1] = s.charAt(n-1);
        for(int i=n-2;i>=0;i--){
            char minChar = (char) Math.min(s.charAt(i), smallestCharToRight[i+1]);
            smallestCharToRight[i] = minChar;
        }
        Stack<Character> t = new Stack<>();
        StringBuilder p = new StringBuilder();
        int i =0;
        while(i<n){
            t.push(s.charAt(i));
            char minCh = ((i+1)<n)? smallestCharToRight[i+1]:s.charAt(i);
            while (!t.isEmpty() && t.peek()<=minCh)
                p.append(t.pop());
            i++;
        }
        while(!t.isEmpty()){
            p.append(t.pop());
        }

        return p.toString();
    }
}
