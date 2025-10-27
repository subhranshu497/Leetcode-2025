package com.oct;

import java.util.ArrayList;
import java.util.List;

public class SparseVector {
    List<int []> list;
    public SparseVector(int[] nums) {
        list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                int [] arr = new int[]{i, nums[i]};
                list.add(arr);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    //binary search , if two arrays of different length
    public int dotProduct(SparseVector vec) {
        int res = 0;
        // find the smaller array
        if(vec.list.size()<list.size()){
            for(int [] arr: vec.list){
                int target = arr[0];
                res +=arr[1]*binarySearchSparseVector(list, target);
            }
        }
        else{
            for(int [] arr: list){
                int target = arr[0];
                res +=arr[1]*binarySearchSparseVector(vec.list, target);
            }
        }
        return res;
    }

    private int binarySearchSparseVector(List<int[]> list, int target) {
        int l = 0;
        int r = list.size()-1;
        while(l <= r){
            int mid = l+(r-l)/2;
            if(list.get(mid)[0]== target)
                return list.get(mid)[1];
            else if(list.get(mid)[0] < target)
                l = mid +1;
            else r = mid-1;
        }
        return 0;
    }
}
