package com.top.interview150.oneDDP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet","code");
        boolean flag = wordBreak(s, wordDict);
        System.out.println(flag);
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String sub = s.substring(j,i);
                if(dp[j] && set.contains(sub)){
                    dp[i] =true;
                    break;
                }
            }
        }
        return dp[n];
    }

    private static boolean wordBreakmemo(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        boolean flag = solveWordBreak(s, set,n, 0, memo);
        return flag;
    }

    private static boolean solveWordBreak(String s, Set<String> set, int n, int i, int [] memo) {
        //base condition
        if(i>=n){
            return true;
        }
        if(memo[i] !=-1)return memo[i]==1?true:false;
        for(int l=i+1;l<=n;l++){
            String sub = s.substring(i,l);
            //String sub1 =s.substring(i+l);
            if(set.contains(sub)&& solveWordBreak(s,set,n,l, memo)){
                memo[i]= 1;
                return true;
            }
        }
        memo[i]= 0;
        return false;
    }
}
