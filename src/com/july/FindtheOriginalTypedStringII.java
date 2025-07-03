package com.july;

import com.februry.MinimumOperationsToExceedThresholdValueII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindtheOriginalTypedStringII {

    private static int MOD = 1000000007;
    public static void main(String[] args) {
        String s = "aabbccdd";
        int k =7;
        int res = possibleStringCountI(s,k);
        System.out.println(res);
    }

    private static int possibleStringCountI(String s, int k) {
        int n = s.length();
        if(k>n)return 0;
        //calculate the freq of each char and store into a list
        List<Integer> group = new ArrayList<>();
        int count =1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                group.add(count);
                count =1;
            }
        }
        group.add(count);
        System.out.println(group);
        long res =0;
        int size = group.size();
        long totalPossibleCombinations = 1;
        for(int l:group){
            totalPossibleCombinations =(totalPossibleCombinations*l)% MOD;
        }
        if(size >=k)
            return (int) totalPossibleCombinations;
        //when k > group size
        //in this case calculate all the invalid string
        int [][] memo = new int[size+1][k+1];
        for(int [] arr:memo)
            Arrays.fill(arr, -1);
        //long invalidStr = invalidStrCount(0,0,group,k, memo);
        for(int i = size-1; i >= 0; i--) {

            int[] prefix = new int[k+1];
            for(int h = 1; h <= k; h++) {
                prefix[h] = (prefix[h-1] + memo[i+1][h-1]) % MOD;
            }

            for(int c = k-1; c >= 0; c--) {

                int l = c + 1;
                int r = c + group.get(i);

                if(r+1 > k) {
                    r = k-1;
                }

                if(l <= r) {
                    memo[i][count] = (prefix[r+1] - prefix[l] + MOD) % MOD;
                }

            }
        }

        long invalidStr = memo[0][0];
        return  (int)(totalPossibleCombinations-invalidStr+MOD)%MOD;
    }

//    private static int invalidStrCount(int i, int count, List<Integer> group, int k,int [][] memo) {
//        //base condition
//        if(i>=group.size()){
//            if(count<k){
//                return 1;
//            }
//            return 0;
//        }
//        if(memo[i][count] !=-1) return memo[i][count];
//        long result =0;
//        for(int idx=1;idx<=group.get(i);idx++){
//            if((count+idx)<k){
//                result =(result+invalidStrCount(i+1, count+idx,group,k, memo))%MOD;
//            }else{
//                break;
//            }
//        }
//        return memo[i][count] = (int) result;
//    }
}
