package com.februry;

import java.util.PriorityQueue;

public class MakeThePrefixSumNonNegative {
    public static void main(String[] args) {
        int [] nums = {3,-5,-2,6};
        int res = makePrefSumNonNegative(nums);
        System.out.println(res);
    }

    private static int makePrefSumNonNegative(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int preSum =0;
        int i =0;
        while(i<n){
            preSum +=nums[i];
            pq.add(nums[i]);
            if(preSum <0){
                int temp = pq.poll();
                preSum -=temp;
                res +=1;
            }
            i++;
        }
        return res;
    }
}
