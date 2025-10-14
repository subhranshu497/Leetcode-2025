package com.oct;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    public static void main(String[] args) {
        List<Integer> nums = List.of(-15, 3, 16,0);
        int k =2;
        System.out.println(hasIncreasingSubarrays(nums, k));
    }

    private static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int i =0;
        int j =1;
        int count =0;
        int pair =0;

        if (k==1) return true;
        while (j<n){
            if(pair ==2)return true;
            boolean flag = true;
            count =k;
            while (count>1 && j<n){
                if(nums.get(j-1)<nums.get(j)){
                    count--;
                }else {
                    flag= false;
                    break;
                }
                j+=1;
            }
            if(!flag || count >1){
                i +=1;
                j = i+1;
                pair =0;
            }else{
                pair +=1;
                j+=1;
            }
        }
        return pair ==2?true:false;
    }
}
