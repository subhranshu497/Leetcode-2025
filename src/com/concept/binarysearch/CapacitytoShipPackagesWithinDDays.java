package com.concept.binarysearch;

public class CapacitytoShipPackagesWithinDDays {
    public static void main(String[] args) {
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int capacity = shipWithinDays(weights, days);
        System.out.println(capacity);
    }

    private static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int minCapacity = 0;
        int maxCapacity = 0;
        // min capacity would be the max number present in the array
        //max capacity would be sum of all elements
        //calculate min and max capacity
        for(int i =0;i<n;i++){
            minCapacity = Math.max(minCapacity, weights[i]);
            maxCapacity +=weights[i];
        }
        int capacity = 0;
        //now we have  the range to calculate capacity
        while(minCapacity<=maxCapacity){
            int midCapacity = minCapacity+(maxCapacity-minCapacity)/2;
            if(isFeasibleCapacity(weights, midCapacity, days)){
                capacity = midCapacity;
                maxCapacity = midCapacity-1;
            }else{
                minCapacity = midCapacity+1;
            }
        }
        return capacity;
    }

    private static boolean isFeasibleCapacity(int[] weights, int capacity, int days) {
        int load =0;
        int daysTaken =1;
            for(int i=0;i<weights.length;i++){
                if(weights[i]>capacity)return false;
                if(load+weights[i]>capacity){
                    daysTaken +=1;
                    load =weights[i];
                }else {
                    load +=weights[i];
                }
            }
            return daysTaken<=days;
    }
}
