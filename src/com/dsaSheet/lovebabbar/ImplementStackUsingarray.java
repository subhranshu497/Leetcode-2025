package com.dsaSheet.lovebabbar;

import java.util.Arrays;

public class ImplementStackUsingarray {
    private int[] arr;
    private int top;

    public ImplementStackUsingarray() {
        arr = new int[1000];
        Arrays.fill(arr, -1);
        top = -1;
    }

    public void push(int x) {
        top +=1;
        arr[top] = x;
    }

    public int pop() {
        int res =-1;
        if(top !=-1){
             res = arr[top];
             top -=1;
        }
        return res;
    }
}
