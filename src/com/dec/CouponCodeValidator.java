package com.dec;

import java.util.*;
import java.util.regex.Pattern;

public class CouponCodeValidator {
    public static void main(String[] args) {
        String [] code = {"SAVE20","","PHARMA5","SAVE@20"};
        String [] businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean [] isActive= {true,true,true,true};
        List<String> res = validateCoupons(code, businessLine, isActive);
        System.out.println(res);
    }

    private static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>list =new ArrayList<>();
        List<String>liste =new ArrayList<>();
        List<String>listg =new ArrayList<>();
        List<String>listp =new ArrayList<>();
        List<String>listr =new ArrayList<>();
        for(int i=0;i<code.length;i++){
            String cur=code[i];
            if(cur.isEmpty())continue;
            if(!stringCheck(cur))continue;
            if(businessLine[i].equals("electronics")&&isActive[i])liste.add(cur);
            if(businessLine[i].equals("grocery")&&isActive[i])listg.add(cur);
            if(businessLine[i].equals("pharmacy")&&isActive[i])listp.add(cur);
            if(businessLine[i].equals("restaurant")&&isActive[i])listr.add(cur);
        }
        Collections.sort(liste);
        Collections.sort(listg);
        Collections.sort(listp);
        Collections.sort(listr);
        list.addAll(liste);
        list.addAll(listg);
        list.addAll(listp);
        list.addAll(listr);
        return list;
    }
    public static boolean stringCheck(String cur){
        for(char c:cur.toCharArray()){
            if(!(Character.isLetterOrDigit(c)||c=='_')){
                return false;
            }
        }
        return true;
    }
}
