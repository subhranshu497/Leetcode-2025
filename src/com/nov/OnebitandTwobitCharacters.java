package com.nov;

import java.util.Stack;

public class OnebitandTwobitCharacters {
    public static void main(String[] args) {
        int [] bits = {1,0,0};
        boolean flag = isOneBitCharacter(bits);
    }
    public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        Stack<Integer> st = new Stack<>();
        if(n==2)return bits[n-2] !=0?false:true;
        int i =n-2;
        while(i>=0){
            if(st.isEmpty())
                st.push(bits[i]);
            else if(st.peek()==1){
                if(bits[i]==0)return false;
                else st.pop();
            }
            i--;
        }
        if(st.isEmpty())return true;
        while(!st.isEmpty()){
            if(st.peek()==1)return false;
            st.pop();
        }
        return true;
    }
}
