package com.februry;

public class FindThePunishmentNumberOfAnInteger {
    public static void main(String[] args) {
        int n = 37;
        int pNum = punishmentNumber(n);
        System.out.println(pNum);
    }

    private static int punishmentNumber(int n) {
        int pSum =0;
        for(int i=1;i<=n;i++){
            int sqr = i * i;
            if(findSumOfDigits(sqr,i)){
                pSum +=sqr;
            }
        }
        return pSum;
    }

    private static boolean findSumOfDigits(int num, int target) {
        //base condition
        if(target < 0 || num < target) return false;
        if(num==target) return true;

        return (findSumOfDigits(num/10 , target-(num%10))||findSumOfDigits(num/100 , target-(num%100))||findSumOfDigits(num/100 , target-(num%100)));
    }
}
