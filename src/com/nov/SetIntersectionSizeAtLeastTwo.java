package com.nov;

import java.util.Arrays;

public class SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        int [][] intervals = {{1,3},{3,7},{8,9}};
        int res = intersectionSizeTwo(intervals);
        System.out.println(res);
    }

    private static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int count = 2;
        int prev1 = intervals[0][1]-1;
        int prev2 = intervals[0][1];
        for(int [] interval:intervals){
            int start = interval[0];
            int end = interval[1];
            if(prev2 < start){
                prev1 = end-1;
                prev2 =end;
                count +=2;
            }else if(prev1 < start){
                if(end == prev2) prev1 = end-1;
                else prev1 = end;
                if(prev1 > prev2){
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }
                count +=1;
            }
        }
        return count;
    }
}
