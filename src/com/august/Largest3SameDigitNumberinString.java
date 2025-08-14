package com.august;

public class Largest3SameDigitNumberinString {
    public static void main(String[] args) {
        String num = "6777133339";
        String res = largestGoodInteger(num);
        System.out.println(res);
    }

    private static String largestGoodInteger(String num) {
        int result = Integer.MIN_VALUE;
        for(int i=2;i<num.length();i++){
            char ch1 = num.charAt(i-2);
            char ch2 = num.charAt(i-1);
            char ch3 = num.charAt(i);
            if(ch1==ch2 && ch2==ch3 && ch3==ch1){
                StringBuilder res = new StringBuilder();
                res.append(ch1);
                res.append(ch2);
                res.append(ch3);
                result = Math.max(Integer.parseInt(res.toString()),result);
            }
        }
        if(result==0){
            return "000";
        }
        return result==Integer.MIN_VALUE?"":result+"";
    }
}
