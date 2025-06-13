package com.concept.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int [] piles = {3,6,7,11};
        int h= 8;
        int k = minEatingSpeed(piles, h);
        System.out.println(k);
    }

    private static int minEatingSpeed(int[] piles, int h) {
        int result = 0;
        //sort the array
        Arrays.sort(piles);
        int n = piles.length;
        //minimum bananas koko can eat is nums[0]
        //maximum bananas koko can eat is nums[n-1]-nums[0]
        //int left =piles[0];
        int left =1;
        int right = piles[n-1];
        //apply binary search
        while(left < right){
            //calculte count of hours each time
            //when count of hours >= h , store the mid as result
            // then search for the minimum value by shrinking from right
            //else expand from left
            int countOfHours =0;
            int mid = left + (right-left)/2;
            int i =0;
            while(i<n){
                if(piles[i]<=mid){
                    countOfHours +=1;
                }else{
                    int div = piles[i]/mid;
                    int rem = piles[i] % mid;
                    countOfHours +=div;
                    countOfHours +=rem==0?0:1;
                }
                i++;
            }
            if(countOfHours <=h){
                //result = mid;
                right = mid;
            }
            else left = mid+1;
        }
        return left;
    }
}
