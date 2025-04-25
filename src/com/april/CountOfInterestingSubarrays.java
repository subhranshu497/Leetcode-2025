package com.april;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CountOfInterestingSubarrays {
    public static void main(String[] args) {
        List<Integer> nums = List.of(3,1,9,6);
        int mod = 3;
        int k =0;
        long count = countInterestingSubarrays(nums, mod,k);
        System.out.println(count);
    }

    private static long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        int n =nums.size();
        long count =0;
        long cumSum =0;
        Map<Integer, Long> map = new HashMap<>();
        map.put(0,1l) ;
    for(int i=0;i<n;i++){
            if(nums.get(i)%mod == k)
                cumSum +=1;
        int rem1= (int)cumSum % mod;
        int rem2 = (rem1-k+mod)%mod;
        count +=map.getOrDefault(rem2,0l);
        map.put(rem1, map.getOrDefault(rem1, 0l)+1);
        }

        return count;
    }
}
