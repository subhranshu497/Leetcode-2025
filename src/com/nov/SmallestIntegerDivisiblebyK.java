package com.nov;

public class SmallestIntegerDivisiblebyK {
    public static void main(String[] args) {
        int k = 17;
        int res = smallestRepunitDivByK(k);
        System.out.println(res);
    }

    private static int smallestRepunitDivByK(int k) {
        int n =1;
        int num =1;
        if(num % k==0) return 1;
        if(num % 2 ==0 || num % 5 ==0)return -1;
        while(num > 0){
            num = ((num*10)+1)%k;
            n++;
            if(n>k) return -1;
            if(num==0)return n;
        }
        return -1;
    }
}
