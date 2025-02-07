package com.februry;

import java.util.*;

public class FindTheNumberOfDistinctColorsAmongTheBalls {
    public static void main(String[] args) {
        int [][] queries = {{1,4},{2,5},{1,3},{3,4}};
        int limit = 4;
        int [] result = queryResults(queries, limit);
        for(int res:result)
            System.out.print(res+", ");
    }

    private static int[] queryResults(int[][] queries, int limit) {
        int n = queries.length;
        int [] result = new int[n];
        Map<Integer, Integer> colorCount = new HashMap<>();
        Map<Integer, Integer> ballmap = new HashMap<>();
int i=0;
        for(int [] query:queries){
            int ball = query[0];
            int color = query[1];
            if(ballmap.containsKey(ball)){
                int prevColor = ballmap.get(ball);
                colorCount.put(prevColor, colorCount.get(prevColor)-1);

                if(colorCount.get(prevColor)==0){
                    colorCount.remove(prevColor);
                }
            }
            ballmap.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color,0)+1);
            result[i++] = colorCount.size();
        }
        return result;
    }
}
