package com.july;

import java.util.Arrays;
import java.util.Map;

public class MaximumNumberofEventsThatCanBeAttendedII {
    public static void main(String[] args) {
        int [][] events ={{1,2,4},{3,4,3},{2,3,1}};
        int k = 2;
        int maxEvents = maxValueII(events, k);
        System.out.println(maxEvents);
    }

    private static int maxValueII(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        int [][] memo = new int[n+1][k+1];
        for(int [] a:memo)
            Arrays.fill(a, -1);
        int res = solveMaxEvents(events,n,0,k, memo);
        return res;
    }

    private static int solveMaxEvents(int[][] events, int n, int i, int k, int [][] memo) {
        //base condition
        if(i>=n || k==0){
            return 0;
        }
        if(memo[i][k] !=-1) return memo[i][k];
        //skip
        int skip = solveMaxEvents(events, n, i+1,k, memo);
        //in case of take find the next i value by linear search
        //startday of i+1 > endday of i
        //linear search
//        int j;
//        for(j=i+1;j<n;j++){
//            int startday = events[j][0];
//            if(startday > events[i][1]) break;
//        }
        int j = binarysearch(events, events[i][1]);
        int take = events[i][2]+solveMaxEvents(events,n,j,k-1, memo);
        return memo[i][k] = Math.max(take, skip);
    }

    private static int binarysearch(int[][] events, int endDay) {
        int l =0;
        int r = events.length;
        int res = 0;
        while (l < r){
            int mid = l+(r-l)/2;
            if(events[mid][0]>endDay){
                r = mid;
            }else
                l = mid+1;
        }
        return l;
    }
}
