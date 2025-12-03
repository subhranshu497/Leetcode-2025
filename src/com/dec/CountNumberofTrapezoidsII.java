package com.dec;

import java.util.*;

public class CountNumberofTrapezoidsII {
    public static void main(String[] args) {
        int [][] points = {{1,0},{2,0},{3,0},{2,2},{3,2}};
        int res = countTrapezoidsII(points);
        System.out.println(res);
    }

    private static int countTrapezoidsII(int[][] points) {
        int n = points.length;
        double MOD = 1e9+7;
        Map<Double, List<Double>> slopeIntercept = new HashMap<>();
        Map<Integer, List<Double>> midpointMap = new HashMap<>();
        int result = 0;
        for(int i=0;i<n;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j=i+1;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x1-x2;
                int dy = y1-y2;
                double slope ;
                double yIntercept ;
                if(x2==x1){ // slope is infinity
                    slope = MOD;
                    yIntercept = x1;
                }else{
                    slope = 1.0 * (y2-y1)/(x2-x1);
                    yIntercept = 1.0 * ((y1*dx)-(x1*dy))/dx;
                }
                // normalize negative zero
                if (slope == -0.0) slope = 0.0;
                if (yIntercept == -0.0) yIntercept = 0.0;
                int key = (x1+x2)*10000+(y1+y2);
                slopeIntercept.computeIfAbsent(slope, k->new ArrayList<>()).add(yIntercept);
                midpointMap.computeIfAbsent(key,k->new ArrayList<>()).add(slope);
            }
        }
        //iterate the y intercepts and store its count
        for(Map.Entry<Double, List<Double>>e:slopeIntercept.entrySet()){
            List<Double> list = e.getValue();
            TreeMap<Double, Integer> map = new TreeMap<>();
            for(double y:list){
                map.put(y, map.getOrDefault(y, 0)+1);
            }
            int prevHorizontalLine =0;
            for(Map.Entry<Double, Integer>e1:map.entrySet()){
                int val = e1.getValue();
                result +=prevHorizontalLine*val;
                prevHorizontalLine +=val;
            }
        }
        //eliminate dups
        for(Map.Entry<Integer, List<Double>>e:midpointMap.entrySet()){
            List<Double> list = e.getValue();
            Map<Double, Integer> map = new HashMap<>();
            for(double y:list){
                map.put(y, map.getOrDefault(y, 0)+1);
            }
            int prevHorizontalLine =0;
            for(Map.Entry<Double, Integer>e1:map.entrySet()){
                int val = e1.getValue();
                result -=prevHorizontalLine*val;
                prevHorizontalLine +=val;
            }
        }

        return result;
    }
}
