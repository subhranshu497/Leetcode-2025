package com.concept.binarysearch;

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target =0;
        int pos = searchII(nums, target);
        System.out.println(pos);
    }

    private static int searchII(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        //if(n==1 && nums[0]==target)return 0;
        while(left <=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[left]<=nums[mid]){//normal binay search
                if(nums[left]<=target && target < nums[mid])
                    right = mid-1;
                else left = mid+1;
            }else { // if(nums[mid]<=tar && tar<numd[rig]
                if(nums[mid]<target && target <= nums[right])
                    left = mid+1;
                else right = mid-1;

            }
        }
        return -1;
    }
}
