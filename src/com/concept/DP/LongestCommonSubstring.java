package com.concept.DP;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "geeksfo";
        String s2 = "geeks";
        int len = lcsubstring(s1, s2);
        System.out.println(len);
    }

    private static int lcsubstring(String s1, String s2) {
        int [][] dp = new int[s1.length()+1][s2.length()+1];
        int res =0;
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                }else {
                    dp[i][j]= 0;
                }
            }
        }
        //print the dp
        for(int i=0;i<=s1.length();i++) {
            for (int j = 0; j <=s2.length(); j++) {
                System.out.print(dp[i][j]+", ");
            }
            System.out.println();
        }
        return res;
    }
}
