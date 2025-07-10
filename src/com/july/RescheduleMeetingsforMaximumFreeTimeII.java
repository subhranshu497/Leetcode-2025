package com.july;

public class RescheduleMeetingsforMaximumFreeTimeII {
    public static void main(String[] args) {
        int [] startTime = {1,3};
        int [] endTime = {2,5};
        int eventTime =5;
        int freeTime = maxFreeTimeII(startTime, endTime, eventTime);
        System.out.println(freeTime);
    }

    private static int maxFreeTimeII(int[] startTime, int[] endTime, int eventTime) {
        int n = startTime.length;
        //first calculate the gap array
        int [] gap = new int[n+1];
        gap[0] = startTime[0];
        for(int i=1;i<n;i++){
            gap[i] = startTime[i]-endTime[i-1];
        }
        //last gap
        gap[n]= eventTime-endTime[n-1];
        //now i have two option to calculate free time with one move
        //first move the meeting to some other location and add the meeting duration to the adjacents gaps
        //second shift the meeting to the adjacent free space and sum the gaps
        //to check the possible right/left move or shift of meeting need to calcculate maxrightgap and maxleftgap
        int [] maxRightGap = new int[gap.length];
        int [] maxLeftGap = new int[gap.length];
        //as there is no element present to the right of right most element
        maxRightGap[maxRightGap.length-1] =0;
        for(int i= gap.length-2;i>=0;i--){
            maxRightGap[i] = Math.max(maxRightGap[i+1], gap[i+1]);
        }
        //as there is no element present to the left of left most element
        maxLeftGap[0] =0;
        for(int i= 1;i< gap.length;i++){
            maxLeftGap[i] = Math.max(maxLeftGap[i-1], gap[i-1]);
        }
        int freeTime = Integer.MIN_VALUE;
        for(int i=1;i< n+1;i++){
            int duration = endTime[i-1]-startTime[i-1];
            //case to move the meeting
            if(Math.max(maxLeftGap[i-1],maxRightGap[i])>=duration){
                freeTime = Math.max(freeTime, duration+gap[i]+gap[i-1]);
            }
            //case for shifting the meeting
            freeTime = Math.max(freeTime, gap[i]+gap[i-1]);
        }
        return freeTime;
    }
}
