package com.august;

public class MaximumAreaofLongestDiagonalRectangle {
    public static void main(String[] args) {
        int [][] dimensions = {{9,3},{8,6}};
        int area = areaOfMaxDiagonal(dimensions);
        System.out.println(area);
    }

    private static int areaOfMaxDiagonal(int[][] dimensions) {
        double area =0;
        double maxDiagonal =0;
        for(int [] dimension:dimensions){
            double prod = (dimension[0]*dimension[0])+(dimension[1]*dimension[1]);
            double diagonal = Math.sqrt(prod);
            if(diagonal > maxDiagonal || (diagonal == maxDiagonal && dimension[0]*dimension[1] > area)){
                maxDiagonal = diagonal;
                area = dimension[0]*dimension[1];
            }
        }
        return (int)area;
    }
}
