package com.amazon.prep.arraysString;

public interface ContainerWithMostWater {
    public static void main(String[] args) {
        int [] heights = {1,8,6,2,5,4,8,3,7};
        int area = maxArea(heights);
        System.out.println(area);
    }

    static int maxArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        int i=0;
        int j = n-1;
        while (i<j){
            int height = Math.min(heights[i], heights[j]);
            int width = j-i;
            area = Math.max(area, height*width);
            if(heights[i]>heights[j])
                j--;
            else if(heights[i] < heights[j])
                i++;
            else{
                i++;
                j--;
            }
        }
        return area;
    }
}
