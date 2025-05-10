package com.may;

import java.util.Arrays;

public class CountNumberofBalancedPermutations {
    private static int n;
    private static long[] factorial;
    private static long [] inverseFactorial;
    private static int mod = 1000000007;
    private static int totalDigitSum;
    private static long totalPermutationPossible = 0;
    public static void main(String[] args) {
        String num = "123";
        int count = countBalancedPermutations(num);
        System.out.println(count);
    }

    private static int countBalancedPermutations(String num) {
        n = num.length();
        totalDigitSum =0;

        int [] freq = new int[10];
        for(int i=0;i<n;i++){
            totalDigitSum +=num.charAt(i)-'0';
            freq[num.charAt(i)-'0']++;
        }
        if(totalDigitSum % 2 !=0) return 0;

        //precomputing factorial
        factorial = new long[n+1];
        factorial[0] =1;

        for(int i=1;i<=n;i++){
            factorial[i] = (i* factorial[i-1])%mod;
        }

        inverseFactorial = new long[n+1];

        for(int i=0;i<=n;i++){
            inverseFactorial[i] = findPower(factorial[i], mod-2);
        }
        
        totalPermutationPossible = (factorial[(n+1)/2]*factorial[n/2]) % mod;
        
        int [][][] memo = new int[10][((n+1)/2)+1][totalDigitSum+1];
        for(int [][] matrix:memo){
            for(int [] arr:matrix)
                Arrays.fill(arr ,-1);
        }
        return solve1(0,0,0, freq,memo);
    }

    private static int solve1(int digit, int evenIndexDigitCount, int currentSum, int[] freq, int[][][] memo) {
        //base condition
        if(digit==10){
            if(currentSum == totalDigitSum/2 && evenIndexDigitCount==(n+1)/2)
                return (int)totalPermutationPossible;
            return 0;
        }
        if(memo[digit][evenIndexDigitCount][currentSum] != -1)
            return memo[digit][evenIndexDigitCount][currentSum];
        long ways =0;
        for(int count =0;count<=Math.min(freq[digit], ((n+1)/2)-evenIndexDigitCount);count++){
            int evenPosCount =count;
            int oddPosCount = freq[digit]-count;

            long div = (inverseFactorial[evenPosCount]*inverseFactorial[oddPosCount])%mod;

            long val = solve1(digit+1, evenIndexDigitCount+evenPosCount, currentSum+(digit*count),freq, memo);

            ways = (ways +(val*div)%mod)%mod;
        }
        return memo[digit][evenIndexDigitCount][currentSum] = (int) ways;
    }

    private static long findPower(long a, int b) {

        if(b==0) return 1;
        long half = findPower(a, b/2);
        long result = (half*half)%mod;

        if(b%2==1)
            result =(result*a)%mod;
        return (int) result;

    }
}
