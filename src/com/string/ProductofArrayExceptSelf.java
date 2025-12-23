package com.string;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int [] ans = productExceptSelf(nums);
        for(int a:ans)
            System.out.print(a+", ");
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] left = new int[n];
        int [] right = new int[n];
        int [] ans = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right,1);
        for(int i=0;i<n;i++){
            if(i==0){
                left[i] =nums[i];
                continue;
            }
            left[i] =left[i-1]*nums[i];
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                right[i] = nums[i];
                continue;
            }
            right[i] =right[i+1]* nums[i];
        }
        for(int i=0;i<n;i++){
            ans[i]= ((i-1)<0?1:left[i-1])*((i+1)>=n?1:right[i+1]);
        }
        return ans;
    }
}
