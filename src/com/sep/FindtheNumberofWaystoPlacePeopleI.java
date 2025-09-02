package com.sep;

import java.util.Arrays;

public class FindtheNumberofWaystoPlacePeopleI {
    public static void main(String[] args) {
        int [][] points =  {{1,1},{2,2},{3,3}};
        int noOfPairs = numberOfPairs(points);
        System.out.println(noOfPairs);
    }

    private static int numberOfPairs(int[][] points) {
        int count =0;
        for(int idx =0;idx< points.length;idx++){
            int x1 = points[idx][0];
            int y1 =points[idx][1];
            for(int i=0;i<points.length;i++){
                if(i==idx)continue;
                int x2 = points[i][0];
                int y2 =points[i][1];
                if(x1 <=x2 && y1>=y2){
                    boolean hasIntermediatePoint = false;
                    for (int k = 0; k < points.length; k++) {
                        if (k == i || k == idx) {
                            continue;
                        }
                        int x3 = points[k][0];
                        int y3 = points[k][1];
                        if (x3 >= x1 && x3 <= x2 && y3 <= y1 && y3 >= y2) {
                            hasIntermediatePoint = true;
                            break;
                        }
                    }
                    if(!hasIntermediatePoint)count++;
                }
            }
        }
        return count;
    }
}
