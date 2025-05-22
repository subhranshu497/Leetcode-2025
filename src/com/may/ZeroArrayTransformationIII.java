package com.may;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ZeroArrayTransformationIII {
    public static void main(String[] args) {
        int [][] queries = {{1,3},{0,2},{1,3},{1,2}};
        int [] nums = {1,1,1,1};
        int count = maxRemoval(nums, queries);
        System.out.println(count);
    }

    private static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int qLength = queries.length;
        int usedCount =0;
        int j =0; // to iterate queries
        //to store the ending index of queries
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        //to store the used indexes of queries retrieved from maxHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(queries, (a,b)->Integer.compare(a[0],b[0]));

        for(int i=0;i<n;i++){
            while(j<qLength && queries[j][0]==i){
                maxHeap.add(queries[j][1]);
                j++;
            }
            //find the farthest endpoint from the maxheap , so that it will impact nums till max extend
            nums[i] -=minHeap.size();
            while(nums[i] >0 && !maxHeap.isEmpty() && maxHeap.peek() >=i){
                int ending = maxHeap.poll();
                minHeap.add(ending);
                usedCount++;
                nums[i]--;
            }
            if(nums[i] >0)
                return -1;
            while(!minHeap.isEmpty() && minHeap.peek() <=i){
                minHeap.poll();
            }
        }
        return qLength-usedCount;
    }
}
