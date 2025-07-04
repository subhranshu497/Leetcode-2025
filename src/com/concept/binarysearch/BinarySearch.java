package com.concept.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int [] nums = {-1,0,3,5,9,12};
        int target = 9;
        int idx = searchI(nums, target);
        System.out.println(idx);
    }

    private static int searchI(int[] nums, int target) {
        int n = nums.length;
        int left =0;
        int right =n-1;
        int idx = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target)
                right = mid-1;
            else{
                idx = mid;
                break;
            }
        }
        return idx;
    }
}
