package com.dec;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeleteColumnstoMakeSortedIII {
    public static void main(String[] args) {
        String[] strs = {"ghi","def","abc"};
        int res = minDeletionSizeIII(strs);
        System.out.println(res);
    }

    private static int minDeletionSizeIII(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int [] dp = new int [n];
        Arrays.fill(dp, 1);
        int LIS =1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                boolean isValid = true;
                for(int k=0;k<m;k++){
                    if(strs[k].charAt(j)>strs[k].charAt(i)){
                        isValid = false;
                        break;
                    }
                }
                if(isValid){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            LIS = Math.max(LIS, dp[i]);
        }
        return n-LIS;
    }
}
