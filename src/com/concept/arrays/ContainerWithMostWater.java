package com.concept.arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] heights = {1,1};
        int area = maxAreaI(heights);
        System.out.println(area);
    }

    private static int maxAreaI(int[] heights) {
        int n = heights.length;
        int [] rightToLeft = new int[n];
        int [] leftToRight = new int[n];
        int area = 0;
        leftToRight[0] = heights[0];
        for(int i=1;i<n;i++){
            leftToRight[i] = Math.max(heights[i], leftToRight[i-1]);
        }
        //fill the array from right to left
        rightToLeft[n-1] = heights[n-1];
        for(int i=n-2;i>=0;i--){
            rightToLeft[i] = Math.max(heights[i],rightToLeft[i+1]);
        }
        int [] resultantHeight = new int[n];
        for(int i=0;i<n;i++){
            resultantHeight[i]= Math.min(leftToRight[i], rightToLeft[i]);
        }
        int i =0;
        int j = n-1;
        while(i<j){
            int height = Math.min(resultantHeight[i], resultantHeight[j]);
            int width = j-i;
            area = Math.max(area, (height*width));
            if(resultantHeight[i]<resultantHeight[j])i++;
            else j--;
        }
        return area;
    }
}
