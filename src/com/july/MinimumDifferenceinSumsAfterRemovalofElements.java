package com.july;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumDifferenceinSumsAfterRemovalofElements {
    public static void main(String[] args) {
        int [] nums = {16,46,43,41,42,14,36,49,50,28,38,25,17,5,18,11,14,21,23,39,23};
        long res = minimumDifference(nums);
        System.out.println(res);
    }

    private static long minimumDifference(int[] nums) {
        long res = Long.MAX_VALUE;
        int len = nums.length;
        int n = len/3;
        //to make the diff minimum
        //sum first will be minimum and sum second will be maximum
        //to calculate it , we need a max heap for first sum
        //need a min heap for second sum
        PriorityQueue<Integer> maxHeapLeft = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeapRight = new PriorityQueue<>();
        long [] leftMinSum = new long[len];
        long [] rightMaxSum = new long[len];
        long leftSum =0;

        for(int i=0;i<2*n;i++){
            maxHeapLeft.offer(nums[i]);
            leftSum +=nums[i];
            if(maxHeapLeft.size()>n){
                leftSum -=maxHeapLeft.poll();
            }
            leftMinSum[i] = leftSum;
        }
        long rightSum =0;
        for(int i=len-1;i>=n;i--){
            minHeapRight.offer(nums[i]);
            rightSum +=nums[i];
            if(minHeapRight.size() >n)
                rightSum -= minHeapRight.poll();
            rightMaxSum[i] = rightSum;

        }
        //traverse for res
        for(int i=n-1;i<=(2*n -1);i++){
            res = Math.min(res, (leftMinSum[i]-rightMaxSum[i+1]));
        }
        return res;
    }
}
