package com.februry;

import java.util.Stack;

public class RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";
        String result = removeOccurrences(s,part);
        System.out.println(result);
    }

    private static String removeOccurrences(String s, String part) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int m = part.length();
        for(int i=0;i<n;i++){
            st.push(s.charAt(i));
            if(st.size() >=m && checkPart(st, m, part)){
                for(int j=0;j<m;j++){
                    st.pop();
                }
            }
        }
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }

    private static boolean checkPart(Stack<Character> st, int m, String part) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(st);
        for(int i = m-1;i>=0;i--){
            if(temp.peek() != part.charAt(i)) return false;
            temp.pop();
        }
        return true;
    }
}
