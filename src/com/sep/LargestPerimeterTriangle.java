package com.sep;

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int [] nums = {1,2,1,10};
        int perimeter = largestPerimeter(nums);
        System.out.println(perimeter);
    }

    private static int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=n-1;i>=0;i--){
            if(i-1<0 || i-2<0)break;
            int sum = nums[i-1]+nums[i-2];
            if(sum >nums[i]) return sum+nums[i];
        }
        return 0;
    }
}
