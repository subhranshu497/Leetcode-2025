package com.july;

import java.util.Arrays;

public class RescheduleMeetingsforMaximumFreeTimeI {
    public static void main(String[] args) {
        int [] startTime = {0,17};
        int [] endTime = {14,19};
        int eventTime =34;
        int k=2;
        int freeTime = maxFreeTime(startTime, endTime, eventTime,k);
        System.out.println(freeTime);
    }

    private static int maxFreeTime(int[] startTime, int[] endTime, int eventTime, int k) {
        int n = startTime.length;
        int freeTime = Integer.MIN_VALUE;
        //calculate and form the gap array
        //there are n meetings means gap is n+1
        int [] gap = new int[n+1];
        gap[0] = startTime[0];
        int j =1;
        int endTimePrev = endTime[0];
        for(int i =1;i<n;i++){
            gap[j] = startTime[i]-endTimePrev;
            endTimePrev= endTime[i];
            j++;
        }
        //check for the last gap
        if(endTimePrev==eventTime)
            gap[j]=0;
        else gap[j] =eventTime-endTimePrev;
//        for(int g:gap)
//            System.out.print(g+", ");
        //iterate the gap array for the result
        //if k = a
        //then windowsize = a+1;
            int count = k+1;
            int sum =0;
            int m =0;
            for(;m< gap.length;m++){
                if(m>=count){
                    sum += gap[m]-gap[m-count];
                }else{
                    sum +=gap[m];
                }
                freeTime = Math.max(freeTime, sum);
            }
        return freeTime;
    }
}
