package com.design;

import java.util.*;

public class MinStack {
    private Stack<int[]> st;

    public MinStack() {
       st = new Stack<>();
    }

    public void push(int val) {
        if(st.empty()){
            st.push(new int []{val, val});
        }else{
            int [] arr = st.peek();
            if(arr[1]< val){
                st.push(new int[]{val, arr[1]});
            }
            else st.push(new int []{val, val});
        }
    }

    public void pop() {
       st.pop();
    }

    public int top() {
        int [] arr = st.peek();
        return arr[0];
    }

    public int getMin() {
        int [] arr = st.peek();
        return arr[1];
    }
}
class Driver{
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        ms.getMin();
        ms.pop();
        ms.top();
        ms.getMin();
    }
}
