package com.dec;

public class NumberofSmoothDescentPeriodsofaStock {
    public static void main(String[] args) {
        int [] prices = {3,2,1,4};
        long ans = getDescentPeriods(prices);
        System.out.println(ans);
    }

    private static long getDescentPeriods(int[] prices) {
        long ans = 1;
        int count =1;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]-prices[i+1]==1)count++;
            else count =1;
            ans +=count;
        }
        return ans;
    }
}
