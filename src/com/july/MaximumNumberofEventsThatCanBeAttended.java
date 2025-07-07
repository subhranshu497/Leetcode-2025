package com.july;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberofEventsThatCanBeAttended {
    public static void main(String[] args) {
        int [][] events = {{1,2},{2,3},{3,4},{1,2}};
        int days = maxEvents(events);
        System.out.println(days);
    }

    private static int maxEvents(int[][] events) {
        int res = 0;
        int n = events.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();// push the end day
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int days =events[0][0];
        int i =0;
        //pick the elemnt which is finishing first
        while(i<n || !minHeap.isEmpty()) {
            if(minHeap.isEmpty()){
                days = events[i][0];
            }
            while (i<n && events[i][0] == days){
                minHeap.add(events[i][1]);
                i++;
            }
            if(!minHeap.isEmpty()){
                minHeap.poll();
                res++;
            }
            days +=1;
            while (!minHeap.isEmpty() && minHeap.peek()<days)
                minHeap.poll();
        }
        return res;
    }
}
