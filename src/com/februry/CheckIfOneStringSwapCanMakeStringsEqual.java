package com.februry;

import java.util.HashMap;
import java.util.Map;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public static void main(String[] args) {
        String s1 = "bankb", s2 = "kannb";
        boolean flag = areAlmostEqual(s1, s2);
        System.out.println(flag);
    }

    private static boolean areAlmostEqual(String s1, String s2) {
        int pos1 = -1;
        int pos2 = -1;
        int count =0;
        for (int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(pos1 ==-1) pos1 =i;
                else if(pos2==-1) pos2 =i;
            }
        }
        if(count==0) return true;
        else if(count==2 && s1.charAt(pos1)==s2.charAt(pos2) && s1.charAt(pos2)==s2.charAt(pos1))
            return true;
        return false;
    }
}
