package com.oct;

public class CalculateMoneyinLeetcodeBank {
    public static void main(String[] args) {
        int n = 10;
        int res = totalMoney(n);
        System.out.println(res);
    }

    private static int totalMoney(int n) {
        int iter = n / 7;
        int st = 0;
        int res = 0;
        int sum =0;
        int count =1;
        while(count <=iter){
            int end = st+7;
            sum += end*(end+1)/2;
            st += count;
            if(count !=1)
                sum =sum-st;
            count++;
        }
        int rem = n % 7;
        int end = st+rem-1;
        int lastSum = end*(end+1)/2;
        if(st != 1){
            lastSum -=st-1;
        }
        res = sum +lastSum;
        return res;
    }
}
