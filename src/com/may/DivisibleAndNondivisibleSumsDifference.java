package com.may;

public class DivisibleAndNondivisibleSumsDifference {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int res = differenceOfSums(n,m);
        System.out.println(res);
    }

    private static int differenceOfSums(int n, int m) {
        //find num1 and num2
        int num1=0;
        int num2 =0;
        for(int i=1;i<=n;i++){
            if(i%m !=0)
              num1 +=i;
            else
             num2 +=i;
        }
        return num1-num2;
    }
}
