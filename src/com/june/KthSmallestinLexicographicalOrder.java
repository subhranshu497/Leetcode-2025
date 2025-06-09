package com.june;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestinLexicographicalOrder {
    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        int num = findKthNumber(n,k);
        System.out.println(num);
    }

    private static int findKthNumber(int n, int k) {
        long currentNum = 1;
        k -=1; // since we count based on zero indexed
        while(k >0){
          int countNum = getCountNumber(currentNum, currentNum+1, n);
          if(countNum <=k){
              currentNum++;
              k -=countNum;
          }else{
              currentNum *=10;
              k -=1;
          }
        }
        return (int)currentNum;
    }

    private static int getCountNumber(long currentNum, long nextNum, int n) {
        int countNum =0;
        while (currentNum <=n){
            countNum +=nextNum-currentNum;
            currentNum *=10;
            nextNum *=10;
            nextNum = Math.min(nextNum, (long)(n+1));
        }
        return countNum;
    }
}
