package com.sep;

import java.util.Set;

public class VowelsGameinaString {
    public static void main(String[] args) {
        String s = "ifld";
        boolean flag = doesAliceWin(s);
        System.out.println(flag);
    }

    private static boolean doesAliceWin(String s) {
        if(s.contains("a")||s.contains("e")||s.contains("i")||s.contains("o")||s.contains("u"))
            return true;
        return false;
    }
}
