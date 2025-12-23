package com.string;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static void main(String[] args) {
        char [] charArr = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int ans = compressI(charArr);
        System.out.println(ans);
    }

    private static int compressI(char[] chars) {
       int i =0, index =0;
       int n = chars.length;
       while(i < n){
           char curr = chars[i];
           int count = 0;
           while(i<n && curr==chars[i]){
               count++;
               i++;
           }
           chars[index] =curr;
           index +=1;
           String s = String.valueOf(count);
           int len = s.length();
           if(count==1){
               continue;
           }
           int k =0;
           while(k<len){
               chars[index] = s.charAt(k);
               index++;
               k++;
           }
       }
       return index;
    }
}
