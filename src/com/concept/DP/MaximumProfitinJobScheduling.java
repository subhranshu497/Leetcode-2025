package com.concept.DP;

import java.util.Arrays;

public class MaximumProfitinJobScheduling {
    public static void main(String[] args) {
        int [] startTime = {1,1,1};
        int [] endTime = {2,3,4};
        int [] profit = {5,6,4};
        int prof = jobSchedulingDP(startTime, endTime, profit);
        System.out.println(prof);
    }

    //it has to be debugged
    private static int jobSchedulingDP(int[] startTime, int[] endTime, int[] profit) {
        //first create the job array
        int n = startTime.length;
        int [][] jobs = new int[n][3];
        for(int i =0;i<n;i++){
            int [] job = new int[]{startTime[i],endTime[i], profit[i]};
            jobs[i] = job;
        }
        //now sort the job array based on the starttime
        Arrays.sort(jobs, (a, b)->a[0]-b[0]);
        //take a dp array
        int [] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int nextIndex = binarySerchForJobNextIndex(jobs, jobs[i][1]);
            int take = jobs[i][2]+dp[nextIndex];
            int skip = dp[i+1];
            dp[i] = Math.max(take, skip);
        }
        return dp[0];
    }

    private static int binarySerchForJobNextIndex(int[][] jobs, int target) {
        int l = 0;
        int r = jobs.length;
        while (l<r){
            int mid = l+(r-l)/2;
            if(mid>target)
                r = mid;
            else l = mid+1;
        }
        return l;
    }
}
