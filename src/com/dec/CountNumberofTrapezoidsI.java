package com.dec;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountNumberofTrapezoidsI {
    private static int MOD = 1000000007;
    public static void main(String[] args) {
        int [][] points = {{1,0},{2,0},{3,0},{2,2},{3,2}};
        int res = countTrapezoids(points);
        System.out.println(res);
    }

    private static int countTrapezoids(int[][] points) {
       long count =0;
       Map<Integer, Integer> map = new HashMap<>();
       //store all the y axis points
        for(int [] point:points){
            map.put(point[1], map.getOrDefault(point[1],0)+1);
        }
        long prevHorizontalLine=0;
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
            int y = e.getKey();
            int val = e.getValue();
            long horizontalLine =(long) val*(val-1)/2;
            count =(count+(prevHorizontalLine*horizontalLine))%MOD;
            prevHorizontalLine +=horizontalLine;
        }
        return (int)(count%MOD);
    }


}
