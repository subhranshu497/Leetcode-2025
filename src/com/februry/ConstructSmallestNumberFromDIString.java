package com.februry;

import java.util.Stack;

public class ConstructSmallestNumberFromDIString {
    public static void main(String[] args) {
        String pattern = "DDD";
        String res = smallestNumber(pattern);
        System.out.println(res);
    }

    private static String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int n = pattern.length();
        int count =1;
        int i =0;
        while(i<n){
            char temp = pattern.charAt(i);
            char ch = (char)(count +'0');
            st.push(ch);
            count++;
            if(temp=='I'){
                while (!st.isEmpty()){
                    char fromStack = st.peek();
                    sb.append(fromStack);
                    st.pop();
                }
            }
            i++;
        }
        st.push((char)(count +'0'));
        while (!st.isEmpty()){
            char fromStack = st.peek();
            sb.append(fromStack);
            st.pop();
        }
        return sb.toString();
    }
}
