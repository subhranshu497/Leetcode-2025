package com.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestSubarraysWithMaximumBitwiseOR {
    private static int j =0;
    public static void main(String[] args) {
        int [] nums = {1,0,2,1,3};
        int [] lenArr = smallestSubarrays(nums);
        for(int num:lenArr)
            System.out.println(num);
    }

    private static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] setBitIndex = new int[31];
        Arrays.fill(setBitIndex, -1);

        for (int i = n - 1; i >= 0; i--) {
            int endIndex = i;
            for (int j = 0; j < 31; j++) {
                if ((nums[i] & (1 << j)) == 0) {
                    if (setBitIndex[j] != -1) {
                        endIndex = Math.max(endIndex, setBitIndex[j]);
                    }
                } else {
                    setBitIndex[j] = i;
                }
            }
            result[i] = endIndex - i + 1;
        }

        return result;
    }
}
