package com.june;

import java.math.BigInteger;

public class LongestBinarySubsequenceLessThanorEqualtoK {
    private static int res=0;
    public static void main(String[] args) {
        String s = "1001010";
        int k = 5;
        int res = longestSubsequence(s, k);
        System.out.println(res);
    }

    private static int longestSubsequence(String s, int k) {
        //count all zeros
        int zeroCount =0;
        int n = s.length();
        for(char ch:s.toCharArray()){
            if(ch=='0')zeroCount++;
        }
        //adding zeros wont increase the num
        int value =0;
        int count =0;
        int power =0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                value +=Math.pow(2,power);
                //value += 1L << power;
                if(value>k){
                    break;
                }
                count++;
            }
            power++;
        }
        return count+zeroCount;
    }
}
