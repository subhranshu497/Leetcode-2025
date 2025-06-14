package com.june;

public class MaximumDifferencebyRemappingaDigit {
    public static void main(String[] args) {
        int num = 90;
        int res = minMaxDifference(num);
        System.out.println(res);
    }

    private static int minMaxDifference(int num) {
        String s = num+"";
        int n = s.length();
        StringBuilder sbMax = new StringBuilder();
        StringBuilder sbMin = new StringBuilder();
        char charToReplaceMax = ' ';
        // find the char to replace for max
        for(char ch:s.toCharArray()){
            if(ch !='9'){
                charToReplaceMax = ch;
                break;
            }
        }
        //construct max
        for(char ch:s.toCharArray()){
            if(ch == charToReplaceMax){
                ch = '9';
            }
            sbMax.append(ch);
        }
        char charReplaceForMin =s.charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==charReplaceForMin) sbMin.append('0');
            else{
                sbMin.append(s.charAt(i));
            }
        }
       String sMax = sbMax.toString();
        String sMin = sbMin.toString();
        System.out.println("max " + sMax);
        System.out.println("min " + sMin);

        int max = Integer.parseInt(sMax);
        int min = Integer.parseInt(sMin);

        return max-min;
    }
}
