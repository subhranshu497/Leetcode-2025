package com.dec;

import java.util.HashMap;
import java.util.Map;

public class CountCoveredBuildings {
    public static void main(String[] args) {
        int n = 3;
        int [][] buildings = {{1,2},{2,2},{3,2},{2,1},{2,3}};
        int count = countCoveredBuildings(n, buildings);
        System.out.println(count);
    }

    private static int countCoveredBuildings(int n, int[][] buildings) {
        int count =0;
        Map<Integer, int[]> rowRange = new HashMap<>();
        Map<Integer, int[]> colRange = new HashMap<>();
        //track min/max of x for each row
        //track min/max of y for each col
        for(int [] building:buildings){
            int x = building[0];
            int y = building[1];
            rowRange.computeIfAbsent(y, k->new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            rowRange.get(y)[0] = Math.min(x, rowRange.get(y)[0]);
            rowRange.get(y)[1] = Math.max(x, rowRange.get(y)[1]);
            colRange.computeIfAbsent(x, k->new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE});
            colRange.get(x)[0] = Math.min(y, colRange.get(x)[0]);
            colRange.get(x)[1] = Math.max(y, colRange.get(x)[1]);
        }
        //traverse each building and check
        for(int [] building:buildings){
            int x = building[0];
            int y = building[1];
            int [] row = rowRange.get(y);
            int [] col = colRange.get(x);
            if(x > row[0] && x<row[1] && y>col[0] && y < col[1]) count++;
        }
        return count;
    }
}
