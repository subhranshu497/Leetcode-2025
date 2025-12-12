package com.slidingwindow;

import java.util.Set;

public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public static void main(String[] args) {
        String s = "leetcode";
        int k =3;
        int count = maxVowels(s,k);
        System.out.println(count);
    }

    private static int maxVowels(String s, int k) {
        int n = s.length();
        Set<Character> vowelSet = Set.of('a','e','i','o','u');
        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        int count =0;
        int subLen =0;
        int res =0;
        while (j<n){
            sb.append(s.charAt(j));
            subLen +=1;
            if(vowelSet.contains(s.charAt(j)))count +=1;
            if(subLen==k){
                res =Math.max(res, count);
               if(vowelSet.contains(sb.charAt(0)))count -=1;
               sb.deleteCharAt(0);
               subLen -=1;
               i++;
            }
            j++;
        }
        return res;
    }
}
