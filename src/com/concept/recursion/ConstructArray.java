package com.concept.recursion;

import java.util.Arrays;

public class ConstructArray {
    private static long mod = 1000000007;
    public static void main(String[] args) {
        int n = 4, k =3, x=2;
        long ways = consArray(n,k,x);
        System.out.println(ways);
    }

    private static long consArray(int n, int k, int x) {
        long[][] memo = new long[n + 1][k + 1];

        for (long[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return consArrRecursion(1, 1, n, k, x, memo);
    }

    private static long consArrRecursion(int pos, int prev, int n, int k, int x, long[][] memo) {
        // base case
        if (pos == n) {
            return prev == x ? 1 : 0;
        }

        if (memo[pos][prev] != -1) return memo[pos][prev];

        long count = 0;
        for (int i = 1; i <= k; i++) {
            if (i != prev) {
                count = (count + consArrRecursion(pos + 1, i, n, k, x, memo)) % mod;
            }
        }

        return memo[pos][prev] = count;
    }
}
