package com.concept.recursion;

import jdk.jshell.execution.JdiDefaultExecutionControl;

import java.util.Arrays;

public class CountPossibleDecodingsofagivenDigitSequence {
    public static void main(String[] args) {
        String digits = "121";
        int ways = countWaysII(digits);
        System.out.println(ways);
    }

    private static int countWaysII(String digits) {
        int n = digits.length();
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        int ways = countWaysIIHelper(digits, n,0, memo);
        return ways;
    }

    private static int countWaysIIHelper(String digits, int n, int i, int [] memo) {
        //base condition
        // in case of single char check , if i reached till n , then the decode is successful
        if(i>=n)
            return 1;
        if(memo[i] !=-1) return memo[i];
        int ways =0;
        if(digits.charAt(i) !=0)
            ways = countWaysIIHelper(digits, n,i+1, memo);
        if((i+1<n)&&(digits.charAt(i)=='1' && digits.charAt(i+1)<='9')
        || (digits.charAt(i)=='2' && digits.charAt(i+1)<='6')){
            ways += countWaysIIHelper(digits,n,i+2, memo);
        }
        return memo[i]=ways;
    }
}
