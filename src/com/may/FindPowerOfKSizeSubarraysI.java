package com.may;

import java.util.Arrays;

public class FindPowerOfKSizeSubarraysI {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,3,2,5};
        int k =3;
        int [] res = resultsArray(nums, k);
        for(int r:res)
            System.out.println(r+", ");
    }

    private static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int m = n-k+1;
        int [] result = new int[m];
        Arrays.fill(result, -1);
        int count =1;
        for(int i=1;i<k;i++){
            if(nums[i] == nums[i-1]+1)
                count++;
            else count =1;
        }
        if(count == k)
            result[0] = nums[k-1];
        int j = k;
        int i =1;
        while(j < n){
            if(nums[j] == nums[j-1]+1)
                count++;
            else count =1;

            if(count >=k)
                result[i] = nums[j];
            j++;
            i++;
        }
        return result;
    }
}
