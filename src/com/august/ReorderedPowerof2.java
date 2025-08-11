package com.august;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReorderedPowerof2 {
    public static void main(String[] args) {
        int n = 10;
        boolean flag = reorderedPowerOf2(n);
        System.out.println(flag);
    }

    public static boolean reorderedPowerOf2(int n) {
        String sortedS = sortedString(n);
        //match it against 2 power
        for(int p=0;p<30;p++){
            double num = Math.pow(2, p);
            int iNum = (int)num;
            String s = sortedString(iNum);
            if(s.equals(sortedS)) return true;
        }
        return false;
    }
    public static String sortedString(int n){
        String s = n+"";
        char [] charArr = s.toCharArray();
        Arrays.sort(charArr);
        String sortedS = new String(charArr);
        return sortedS;
    }
    public static long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
        return res;
    }
}
