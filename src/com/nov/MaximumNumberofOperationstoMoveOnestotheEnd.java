package com.nov;

public class MaximumNumberofOperationstoMoveOnestotheEnd {
    public static void main(String[] args) {
        String s = "1001101";
        int ops = maxOperations(s);
        System.out.println(ops);
    }

    private static int maxOperations(String s) {
        int ops =0;
        boolean flag = false;
        int countOnes =0;
        for(char ch:s.toCharArray()){
            if(ch=='0') flag = true;
            else{
                if(flag){
                    ops +=countOnes;
                }
                countOnes++;
                flag=false;
            }
        }
        if(flag)
            ops +=countOnes;
        return ops;
    }
}
