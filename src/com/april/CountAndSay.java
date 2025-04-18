package com.april;

public class CountAndSay {
    public static void main(String[] args) {
        int n =4;
        String s = countAndSay(n);
        System.out.println(s);
    }

    private static String countAndSay(int n) {
        //base condition
        if(n==1)return "1";
        String sub = countAndSay(n-1);
        String res = "";
        for(int i=0;i<sub.length();i++){
            char ch = sub.charAt(i);
            int count =1;

            while(i<sub.length()-1 && sub.charAt(i)==sub.charAt(i+1)){
                count++;
                i++;
            }
            res +=String.valueOf(count)+String.valueOf(ch);
        }
        return res;
    }
}
