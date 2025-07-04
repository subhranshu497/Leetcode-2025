package com.concept.binarysearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int [] nums = {1,2,1,3,5,6,4};
        int peak = findPeakElement(nums);
        System.out.println(peak);
    }

    private static int findPeakElement(int[] nums) {
        return searchRecursion(nums, 0, nums.length-1);
    }

    private static int searchRecursion(int[] nums, int left, int right) {
        //base condition
        if(left==right) return left;
        int mid = left+(right-left)/2;
        if(nums[mid] > nums[mid+1]){
            right = mid;
            return searchRecursion(nums, left,right);
        }
        return searchRecursion(nums,mid+1, right);
    }
}
