package com.nov;

public class CheckIfAllOneAreAtLeastLengthKPlacesAway {
    public static void main(String[] args) {
        int [] nums = {1,0,0,1,0,1};
        int k =2;
        boolean res = kLengthApart(nums, k);
        System.out.println(res);
    }

    private static boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int prev=-1;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                if(prev !=-1 && i-prev-1 < k)return false;
                prev =i;
            }
        }
        return true;
    }
}
