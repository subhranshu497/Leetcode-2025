package com.concept.binarysearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target = 7;
        int pos = searchInsert(nums, target);
        System.out.println(pos);
    }

    private static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left =0;
        int right = n-1;
        int pos = -1;
        while(left <=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                pos = mid;
                return pos;
            }
        }
        //if(nums[left]>target && nums[right]<target)return left;

        return left;
    }
}
