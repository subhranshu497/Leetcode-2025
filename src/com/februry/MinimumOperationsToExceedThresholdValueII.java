package com.februry;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {
    public static void main(String[] args) {
        int [] nums = {999999999,999999999,999999999};
        int k = 1000000000;
        int ops = minOperations(nums,k);
        System.out.println(ops);
    }

    private static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq =new PriorityQueue<>();
        //put elements to pq
        for(int num:nums){
            pq.add((long)num);
        }
        //find no of ops
        int ops =0;
        while(pq.peek() < k){
            long x = pq.poll();
            long y = pq.poll();
            long z = (Math.min(x,y)*2)+(Math.max(x,y));
            pq.add(z);
            ops++;
        }
        return ops;
    }
}
