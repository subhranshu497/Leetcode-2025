package com.july;

import java.util.Arrays;
import java.util.Map;

public class FindtheMaximumLengthofValidSubsequenceI {
    public static void main(String[] args) {
        int [] nums = {1,3};
        int count = maximumLength(nums);

        System.out.println(count);
    }

    private static int maximumLength(int[] nums) {
        // run run lis for 0 and then for 1
        // find the max and return
        int count = Math.max(LISSub(nums),LISSub(nums));
        return count;
    }

    private static int LISSub(int [] nums){
        int n = nums.length;
//        int [] dp = new int[n];
//        int [] dp0 = new int[n];
        int [][] dp = new int[2][n];
        int res =1;
//        Arrays.fill(dp, 1);
//        Arrays.fill(dp0, 1);
        Arrays.fill(dp[0],1);
        Arrays.fill(dp[1],1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int rem = (nums[i]+nums[j])%2;
                dp[rem][i] = Math.max(dp[rem][i], dp[rem][j]+1);
                res = Math.max(dp[rem][i], res);
//                if(rem==1){
//                    dp[i] = Math.max(dp[][i], dp[j]+1);
//                    res = Math.max(dp[i], res);
//                }else{
//                    dp0[i] = Math.max(dp0[i], dp0[j]+1);
//                    res = Math.max(dp0[i], res);
//                }
            }
        }
        return res;
    }

    private static int maximumLengthI(int[] nums) {
        int n = nums.length;
        int oddCount =0;
        int evenCount =0;
        int altPairty =0;
        for(int num:nums){
            if(num % 2 == 0)
                evenCount++;
            else oddCount++;
        }
        //pick alt pairty
        int pairtyFlag = nums[0]%2;
        altPairty +=1;
        for(int i=1;i<n;i++){
            if(nums[i] % 2 !=pairtyFlag){
                altPairty +=1;
                pairtyFlag = nums[i]%2;
            }
        }
        return Math.max(oddCount, Math.max(evenCount, altPairty));
    }
}
