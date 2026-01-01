package com.dec;

public class DietPlanPerformance {
    public static void main(String[] args) {
        int [] calories = {3,2};
        int lower = 0;
        int upper = 1;
        int k =2;
        int count = dietPlanPerformance(calories, lower, upper, k);
        System.out.println(count);
    }

    private static int dietPlanPerformance(int[] calories, int lower, int upper, int k) {
        int n = calories.length;
        int res = 0;
        int count =0;
        int l =0;
        int r = 0;
        int sum =0;
        while (r<n){
            while(r<n && count<k){
                sum +=calories[r];
                count++;
                r++;
            }
            if(sum > upper) res +=1;
            else if(sum < lower) res -=1;
            count -=1;
            sum -=calories[l];
            l++;
        }
        return res;
    }
}
