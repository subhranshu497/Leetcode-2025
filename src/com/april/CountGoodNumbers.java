package com.april;

public class CountGoodNumbers {
    private static long mod = 1000000007;
    public static void main(String[] args) {
        long n =4;
        int res = countGoodNumbers(n);
        System.out.println(res);
    }

    private static int countGoodNumbers(long n) {
        long evens = (n+1)/2;
        long odds = n/2;
        long evenPart = calculateExp(5, evens);
        long oddPart = calculateExp(4, odds);
        return (int) ((evenPart*oddPart) % mod);
    }

    private static long calculateExp(long base, long exp) {
        //base condition
        if(exp ==0) return 1;

        long half = calculateExp(base, exp/2);
        long res = (half * half)%mod;

        if(exp % 2 == 1){
            res = (res * base)%mod;
        }
        return res;
    }
}
