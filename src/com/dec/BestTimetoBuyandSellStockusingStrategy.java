package com.dec;

public class BestTimetoBuyandSellStockusingStrategy {
    public static void main(String[] args) {
        int [] prices = {4,2,8};
        int [] strategy = {-1,0,1};
        int k =2;
        long profit = maxProfitI(prices, strategy, k);
        System.out.println(profit);
    }

    private static long maxProfitI(int[] prices, int[] strategy, int k) {
        long originalProfit = 0;
        int n = prices.length;
        long[] originProfitArr = new long[n];
        for (int i = 0; i < n; i++) {
            originProfitArr[i] = prices[i] * strategy[i];
            originalProfit += originProfitArr[i];
        }
        int i = 0;
        int j = 0;
        long originWindowProfit = 0;
        long modifiedWindowProfit = 0;
        long maxGain =0;
        while (j < n) {
            originWindowProfit += originProfitArr[j];
            if (j - i + 1 > k / 2)
                modifiedWindowProfit += prices[j];
            if (j - i + 1 > k) {
                originWindowProfit -= originProfitArr[i];
                modifiedWindowProfit -= prices[i + k / 2];
                i++;
            }

            // Evaluate window of size k
            if (j - i + 1 == k) {
                maxGain = Math.max(maxGain, modifiedWindowProfit - originWindowProfit);
            }

            j++;
        }

        return originalProfit + maxGain;
    }
}
