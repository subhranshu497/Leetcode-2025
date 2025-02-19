package com.februry;

import java.util.ArrayList;
import java.util.List;

public class ThekthLexicographicalStringOfAllHappyStringsOfLengthn {
    public static void main(String[] args) {
        int n =3;
        int k=9;
        String res = getHappyString(n,k);
        System.out.println(res);
    }

    private static String getHappyString(int n, int k) {
        StringBuilder current = new StringBuilder();
        List<String> result = new ArrayList<>();
        getHappyStringBacktracking(current, result, n);

        return result.size() <k ? "":result.get(k-1);
    }

    private static void getHappyStringBacktracking(StringBuilder current, List<String> result, int n) {
        //base condition
        if(current.length()==n){
            result.add(current.toString());
            return;
        }
        for(char ch='a';ch<='c';ch++){
            if(current.length()>0 && current.charAt(current.length()-1)==ch) continue;
            getHappyStringBacktracking(current.append(ch), result, n);
            //undo
            current.deleteCharAt(current.length()-1);
        }
    }
}
