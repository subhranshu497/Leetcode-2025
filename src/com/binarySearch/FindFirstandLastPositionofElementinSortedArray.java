package com.binarySearch;

import java.util.List;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        int [] res = searchRange(nums, target);
        System.out.println(res[0]+"    "+res[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        int n =nums.length;
        if(n==0)return new int[]{-1,-1};
        int leftBound = searchForLeftRange(nums, target, n);
        int rightBound = searchForRightRange(nums, target, n);
        return new int[]{leftBound, rightBound};
    }

    private static int searchForLeftRange(int[] nums, int target, int n) {
        int left = 0;
        int right = n-1;
        int leftBound =-1;
        while(left <=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                leftBound = mid;
                right = mid-1;
            }
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return leftBound;
    }
    private static int searchForRightRange(int[] nums, int target, int n) {
        int left = 0;
        int right = n-1;
        int rightBound =-1;
        while(left <=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                rightBound = mid;
                left = mid+1;
            }
            else if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return rightBound;
    }
}
