package com.dec;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimizeProductSumofTwoArrays {
    public static void main(String[] args) {
        int [] nums1 = {5,3,4,2};
        int [] nums2 = {4,2,2,5};
        int res = minProductSum(nums1, nums2);
        System.out.println(res);
    }

    private static int minProductSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        PriorityQueue<Integer> minHeapNums1 = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapNums2 = new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        while(i<n){
            minHeapNums1.offer(nums1[i]);
            maxHeapNums2.offer(nums2[i]);
            i++;
        }
        int prod =0;
        while(!maxHeapNums2.isEmpty()){
            prod +=maxHeapNums2.poll()*minHeapNums1.poll();
        }
        return prod;
    }
}
