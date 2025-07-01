package com.july;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindtheOriginalTypedStringI {
    public static void main(String[] args) {
        String word = "abbcccc";
        int count = possibleStringCount(word);
        System.out.println(count);
    }

    private static int possibleStringCount(String word) {
        int n = word.length();
        int i =1;
        int res =n;
        while (i<n){
            char ch1 = word.charAt(i);
            char ch2 = word.charAt(i-1);
            if(ch1 !=ch2){
                res--;
            }
            i++;
        }
        return res;
    }
}
