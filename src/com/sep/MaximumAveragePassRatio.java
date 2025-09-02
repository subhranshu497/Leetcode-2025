package com.sep;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        int [][] classes = {{1,2},{3,5},{2,2}};
        int extraStud = 2;
        double res = maxAverageRatio(classes, extraStud);
        System.out.println(res);
    }

    private static double maxAverageRatio(int[][] classes, int extraStud) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> Double.compare(b[0],a[0]));
        //populate the pq
        for(int i=0;i<n;i++){
            double currPr = classes[i][0]/classes[i][1];
            double newPr = classes[i][0]+1/classes[i][1]+1;
            double delta = newPr-currPr;
            pq.add(new double[]{delta, (double) i});
        }

        while (extraStud-- >0){
            double[] curr = pq.poll();
            int i = (int) curr[1];
            classes[i][0]++;
            classes[i][1]++;
            double currPr = classes[i][0]/classes[i][1];
            double newPr = classes[i][0]+1/classes[i][1]+1;
            double delta = newPr-currPr;
            pq.add(new double[]{delta, (double) i});
        }
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += (double) classes[i][0] / classes[i][1];
        }

        return result / n;
    }
}
