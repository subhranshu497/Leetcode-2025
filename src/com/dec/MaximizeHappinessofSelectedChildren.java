package com.dec;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeHappinessofSelectedChildren {
    public static void main(String[] args) {
        int [] happiness = {1,2,3};
        int k = 2;
        long res = maximumHappinessSum(happiness, k);
        System.out.println(res);
    }

    private static long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int happyness:happiness){
            pq.offer(happyness);
        }
        int count = 0;
        long happynessSum = 0;
        for(int i=0;i<k;i++){
            happynessSum +=Math.max(pq.poll()-count, 0);
            count++;
        }
        return happynessSum;
    }
}
