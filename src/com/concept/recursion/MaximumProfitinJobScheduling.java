package com.concept.recursion;

import java.util.Arrays;

public class MaximumProfitinJobScheduling {
    public static void main(String[] args) {
        int [] startTime = {1,1,1};
        int [] endTime = {2,3,4};
        int [] profit = {5,6,4};
        int prof = jobScheduling(startTime, endTime, profit);
        System.out.println(prof);
    }

    private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //first create the job array
        int n = startTime.length;
        int [][] jobs = new int[n][3];
        for(int i =0;i<n;i++){
            int [] job = new int[]{startTime[i],endTime[i], profit[i]};
            jobs[i] = job;
        }
        //now sort the job array based on the starttime
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        //use memoization as simple recursion gave TLE
        int [] memo = new int[n+1];
        Arrays.fill(memo, -1);
        int prof = solveJobScheduling(jobs, n,0, memo);
        return prof;
    }

    private static int solveJobScheduling(int[][] jobs, int n, int i, int [] memo) {
        //base condition
        if(i>=n){
            return 0;
        }
        if(memo[i] !=-1)
            return memo[i];
        //lets go for take and skip
        //as the skip is simple lets go for skip girst
        int skip = solveJobScheduling(jobs, n, i+1, memo);
        //now consider take case
        //first calculate the the next index
        //next index would be whose starttime[j]>=endtime[i]
        //it is linear search
        int j =i;
        for(;j<n;j++){
            if(jobs[j][0]>=jobs[i][1])
                break;
        }
        int take =jobs[i][2]+ solveJobScheduling(jobs,n,j, memo);
        return memo[i] = Math.max(take, skip);
    }
}
