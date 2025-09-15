package com.sep;

import java.util.Map;

public class CheckIfaNumberIsMajorityElementinaSortedArray {
    public static void main(String[] args) {
        int [] nums = {10,100,101,101};
        int target = 101;
        boolean ans = isMajorityElement(nums, target);
        System.out.println(ans);
    }

    private static boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int m = n/2;
        int l = 0;
        int r = n;
        int letterCount =0;
        while (l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target)
                r = mid-1;
            else{
              int pos = mid+1;
              while(mid>=0 && nums[mid]==target){
                  letterCount +=1;
                  mid--;
              }
                while(pos<n && nums[pos]==target){
                    letterCount +=1;
                    pos++;
                }
            }
            if(letterCount>m)return true;
            else return false;
        }
        return false;
    }
}
