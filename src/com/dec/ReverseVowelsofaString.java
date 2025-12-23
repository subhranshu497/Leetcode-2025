package com.dec;

import java.util.Set;

public class ReverseVowelsofaString {
    public static void main(String[] args) {
        String s = "IceCreAm";
        String res = reverseVowels(s);
        System.out.println(res);
    }

    private static String reverseVowels(String s) {
        int n = s.length();
        Set<Character> vowelSet = Set.of('a','e','i','o','u','A','E','I','O','U');
        char [] charArr = s.toCharArray();
        int i=0, j=n-1;
        while(i<j){
            char chleft = charArr[i];
            char chRight = charArr[j];
            if(vowelSet.contains(chleft) && vowelSet.contains(chRight)){
                charArr[i++] = chRight;
                charArr[j--] = chleft;
            }else if(vowelSet.contains(chleft)) j--;
            else if (vowelSet.contains(chRight))i++;
            else{
                i++;
                j--;
            }
        }
        return String.valueOf(charArr);
    }
}
