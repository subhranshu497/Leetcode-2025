package com.dsaSheet.lovebabbar;

import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int [] arr ={7, 10, 4, 3, 20, 15};
        int k = 3;
        int res = kthSmallest(arr, k);
        System.out.println(res);
    }

    private static int kthSmallest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a:arr)
            pq.offer(a);

        while(k>1){
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}
