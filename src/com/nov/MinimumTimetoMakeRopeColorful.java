package com.nov;

public class MinimumTimetoMakeRopeColorful {
    public static void main(String[] args) {
        int [] needTime = {1,2,3,4,5};
       String colors = "abaac";
       int time = minCost1(needTime, colors);
        System.out.println(time);
    }

    private static int minCost1(int[] neededTime, String colors) {
        int n = neededTime.length;
        int i=0;
        int time =0;
        int prev = 0;
        while(i<n){
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1)){
                prev = 0;
            }
            time +=Math.min(prev, neededTime[i]);
            prev= Math.max(prev, neededTime[i]);
            i++;
        }
        return time;
    }
}
