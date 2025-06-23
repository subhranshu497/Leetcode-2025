package com.dsaSheet.lovebabbar;

public class ReverseString {
    public static void main(String[] args) {
        String s = "Geeks";
        String res = reverseStringI(s);
        System.out.println(res);
    }

    private static String reverseStringI(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int j=n-1;j>=0;j--){
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
