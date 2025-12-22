package com.string;

public class GreatestCommonDivisorofStrings {
    public static void main(String[] args) {
        String str1 = "LEET";
        String str2 = "CODE";
        String res = gcdOfStrings(str1, str2);
        System.out.println(res);
    }

    private static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        int len1 = str1.length();
        int len2 = str2.length();
        int endIndex = gcdOfStringHelper(len1, len2);
        System.out.println(endIndex);
        String res = "";
        if(len1>len2){
            res = str1.substring(0,endIndex);
        }else res = str2.substring(0,endIndex);
        return res;
    }

    private static int gcdOfStringHelper(int num1, int num2) {
        if(num2 ==0) return num1;
       return gcdOfStringHelper(num2, num1%num2);
    }
}
