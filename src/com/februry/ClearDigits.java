package com.februry;

public class ClearDigits {
    public static void main(String[] args) {
        String s = "cb34";
        String str = clearDigits(s);
        System.out.println(str);
    }

    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch :s.toCharArray()){
            if(Character.isDigit(ch)){
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
