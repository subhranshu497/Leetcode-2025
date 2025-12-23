package com.dec;

import java.util.Arrays;

public class TwoBestNonOverlappingEvents {
    private static int n;
    public static void main(String[] args) {
        int [][] events = {{1,3,2},{4,5,2},{2,4,3}};
        int res = maxTwoEvents(events);
        System.out.println(res);
    }
    public static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b)->a[0]-b[0]);
        n = events.length;
        int [][] memo = new int [n+1][2];
        for(int [] a:memo){
            Arrays.fill(a, -1);
        }
        int ans = maxTwoEventsHelper(events,0,0, memo);
        return ans;
    }
    public static  int maxTwoEventsHelper(int [][] events, int i, int count, int [][] memo){
        //base condition
        if(count ==2 || i>=n)return 0;
        if(memo[i][count] != -1)
            return memo[i][count];

        //take
        int nextIdx = findNextIdx(events, events[i][1]);

        int take = events[i][2]+ maxTwoEventsHelper(events,nextIdx,count+1, memo);
        //skip
        int skip = maxTwoEventsHelper(events, i+1,count, memo);
        return memo[i][count] = Math.max(take, skip);
    }
    private static int findNextIdx(int [][] events, int endIdxPrev){
        int l =0;
        int r = n-1;
        int res = n;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(endIdxPrev < events[mid][0]){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
}
