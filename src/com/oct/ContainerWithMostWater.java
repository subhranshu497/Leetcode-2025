package com.oct;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea1(height);
        System.out.println(maxArea);
    }

    private static int maxArea1(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int maxArea = Integer.MIN_VALUE;
        while (i != j){
            int h = Math.min(height[i], height[j]);
            int w = j-i;
            maxArea = Math.max(maxArea, h*w);
            if(height[i]<height[j])
                i++;
            else j--;
        }
        return maxArea;
    }
}
