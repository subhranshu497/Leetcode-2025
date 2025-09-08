package com.sep;

public class ConvertIntegertotheSumofTwoNoZer0Integers {
    public static void main(String[] args) {
        int n =11;
        int [] res = getNoZeroIntegers(n);
        System.out.println(res[0]+"  "+res[1]);
    }

    private static int[] getNoZeroIntegers(int n) {
        int [] res = new int[2];
        int i =1;

        while(i<n){
            int j =n-i;
            if (!String.valueOf(i).contains("0") && !String.valueOf(j).contains("0")){
                return new int[]{i,j};
            }
            i++;
        }
        return res;
    }
}
