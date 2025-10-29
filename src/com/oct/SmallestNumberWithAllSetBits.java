package com.oct;

public class SmallestNumberWithAllSetBits {
    public static void main(String[] args) {
        int n = 5;
        int num = smallestNumberII(n);
        System.out.println(num);
    }

    private static int smallestNumberI(int n) {
        int count =0;
        while(n>0){
             n /=2;
            if(n>0) count++;
        }
        count +=1;
        int res = (int) Math.pow(2, count);

        return res-1;
    }
    private static int smallestNumberII(int n) {
        int count =0;
        while(n>0){
            n = n>>1;
            if(n>0) count++;
        }
        count +=1;
        int res = 1<<count;

        return res-1;
    }
}
