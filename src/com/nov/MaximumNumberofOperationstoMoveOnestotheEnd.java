package com.nov;

public class MaximumNumberofOperationstoMoveOnestotheEnd {
    public static void main(String[] args) {
        String s = "1001101";
        int ops = maxOperations(s);
        System.out.println(ops);
    }

    private static int maxOperations(String s) {
        int n = s.length();
        int ops =0;
        int countOns = 0;
        int i=0;
        while(i<n){
            if(s.charAt(i)=='0'){
                ops +=countOns; //1
                while (i<n && s.charAt(i)=='0') i++;
            }
            else {
                countOns +=1;
                i++;
            }
        }
        return ops;
    }
}
