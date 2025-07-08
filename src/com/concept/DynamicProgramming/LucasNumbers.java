package com.concept.DynamicProgramming;

public class LucasNumbers {
    public static void main(String[] args) {
        int n =4;
        int res = lucas(n);
        System.out.println(res);
    }

    //recursion
    private static int lucas(int n) {
        //base case
        if(n==0) return 2;
        if(n==1) return 1;

        return lucas(n-1)+lucas(n-2);
    }
}
