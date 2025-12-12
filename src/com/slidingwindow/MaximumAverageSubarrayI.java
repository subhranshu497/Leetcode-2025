package com.slidingwindow;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int [] nums = {-1};
        int k = 1;
        double ans = findMaxAverage(nums, k);
        System.out.println(ans);
    }

    private static double findMaxAverage(int[] nums, int k) {
        double ans =Double.NEGATIVE_INFINITY;
        int n = nums.length;
        int i=0,j=0;
        double sum =0;
        int l = 0;
        while (j<n){
            sum +=nums[j];
            l +=1;
            if(l==k){
                ans = Math.max(ans, sum/k);
                sum -=nums[i];
                l -=1;
                i++;
            }
            j++;
        }
        return ans;
    }
}
