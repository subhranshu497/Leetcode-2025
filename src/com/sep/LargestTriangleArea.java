package com.sep;

public class LargestTriangleArea {
    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        double area = largestTriangleArea(points);
        System.out.println(area);
    }

    //area calculated using shoe lace formula
    private static double largestTriangleArea(int[][] points) {
        int n = points.length;
        double area = 0.0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    double tempArea = 0.5*(Math.abs( x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)));
                    area = Double.max(area, tempArea);
                }
            }
        }
        return area;
    }
}
