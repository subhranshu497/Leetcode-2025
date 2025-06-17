package com.june;

import java.util.Arrays;

public class CounttheNumberofArrayswithKMatchingAdjacentElements {

    private static int MOD = 1000000007;
    public static void main(String[] args) {
        int n = 5, m = 2, k = 0;
        int totalArrays = countGoodArrays(n,m,k);
        System.out.println(totalArrays);
    }

    public static int countGoodArrays(int n, int m, int k) {
        //we have n elements and we need k pairs
        // so total no of ways will be nCk
        //here max value of n is m which is n-1
        // n-1 C k
        //(n-1)!/((k!)*(n-1-k)!)
        //now on the arragemen wise we have to find k pairs, where the first place of the pair can be filled m number of ways
        // the other place of the pair can be filled only one way
        //for the next pair, we have m-1 number of ways to fill
        // so the equation would be m*(m-1)^(n-k-1)
        //result = (n-1)!/((k!)*(n-1-k)!) * m*(m-1)^(n-k-1)

        //lets precompute the factorial
        long [] factorial = new long[n+1];
        factorial[0] = 1;
        for(int i=1;i<factorial.length;i++){
            factorial[i] = (factorial[i-1]*i)%MOD;
        }
        //now precompute inverse of factorial using fermat's little theorem
        long [] inverseFactorial = new long[n+1];
        Arrays.fill(inverseFactorial, 1);
        for(int i=0;i<inverseFactorial.length;i++){
            inverseFactorial[i] = calculatePower(factorial[i], MOD-2);
        }
        //form the result
        // calculate nCr now
        long res = calculatenCr(n-1,k, factorial, inverseFactorial);
        res = res *m %MOD;
        res = res * calculatePower(m-1, n-k-1)%MOD;

        return (int)res;
    }
    private static long calculatenCr(int n, int r, long [] factorial, long [] invFactorial) {

        return factorial[n]*invFactorial[r]%MOD *invFactorial[n-r]%MOD;
    }
    public static long calculatePower(long a, long b) {
        long result = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1)
                result = (result * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }
}
