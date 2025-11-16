package com.nov;

public class NumberofSubstringsWithOnlyOnes {
    private static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        String s = "0110111";
        int res = numSub(s);
        System.out.println(res);
    }

    private static int numSub(String s) {
        int res = 0;
        int countOnes =0;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                countOnes++;
                res = (res+countOnes)%MOD;
            }else countOnes=0;
        }
        return res;
    }
}
