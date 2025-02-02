package com.februry;

import javax.swing.*;
import java.util.*;

public class DistinctNumbersInEachSubarray {
    public static void main(String[] args) {
        int [] nums = {1,2,3,2,2,1,3};
        int k = 3;
        int [] res = distinctNumbers(nums, k);
    }

    private static int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[n-k+1];
        int i =0;
        int j = k;
        int m =0;
        Map<Integer, Integer> map = new HashMap<>();
        while(i < k){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            i++;
        }
        ans[m++] = map.size();
        while (j<n){
            map.put(nums[j-k],map.getOrDefault(nums[j-k],0)-1);
            if(map.get(nums[j-k])==0)
                map.remove(nums[j-k]);
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            ans[m++]= map.size();
            j++;
        }
        return ans;
    }
}
