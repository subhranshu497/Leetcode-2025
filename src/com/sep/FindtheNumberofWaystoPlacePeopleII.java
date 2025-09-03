package com.sep;

import java.util.Arrays;

public class FindtheNumberofWaystoPlacePeopleII {
    public static void main(String[] args) {
        int [][] points =  {{1,1},{2,2},{3,3}};
        int noOfPairs = numberOfPairs(points);
        System.out.println(noOfPairs);
    }

    private static int numberOfPairs(int[][] points) {
        int count =0;
        Arrays.sort(points, (a, b)->{
            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else return Integer.compare(b[1], a[1]);
        });
        for(int idx =0;idx< points.length;idx++){
            int x1 = points[idx][0];
            int y1 =points[idx][1];
            int maxY = Integer.MIN_VALUE;
            for(int i=idx+1;i<points.length;i++){
                int x2 = points[i][0];
                int y2 =points[i][1];
                if(y2>y1)continue;
                if(y2>maxY){
                    count++;
                    maxY = y2;
                }
            }
        }
        return count;
    }
}
