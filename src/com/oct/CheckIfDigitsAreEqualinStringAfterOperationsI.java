package com.oct;

public class CheckIfDigitsAreEqualinStringAfterOperationsI {
    public static void main(String[] args) {
        String s = "3902";
        boolean flag = hasSameDigits(s);
        System.out.println(flag);
    }

    private static boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n =s.length();
        while(n>2){
            int i=0;
            while(i<n-1){
                int first = (sb.charAt(i)+ sb.charAt(i+1)) %10;
                sb.setCharAt(i, (char) first);
                i++;
            }
            n--;
        }
        return sb.charAt(0)==sb.charAt(1);
    }
}
