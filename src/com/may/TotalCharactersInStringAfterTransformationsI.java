package com.may;

public class TotalCharactersInStringAfterTransformationsI {
    private static long mod = 1000000007;
    public static void main(String[] args) {
        String s = "jqktcurgdvlibczdsvnsg";
        int t =7517;
        int len = lengthAfterTransformations(s,t);
        System.out.println(len);

    }

    private static int lengthAfterTransformations(String s, int t) {
        long [] charArr = new long[26];
        long res = 0;
        for(int i=0;i<s.length();i++){
            charArr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t;i++){
            long [] dp = new long[26];
            for(int j=0;j<26;j++){
                if(j==25){
                    dp[0] =(dp[0]+charArr[j])%mod;
                    dp[1] =(dp[1]+charArr[j])%mod;
                }
                else{
                    dp[j+1] = (dp[j+1]+charArr[j])%mod;
                }
            }
            charArr = dp;
        }
        for(long l:charArr)
            res = (l+res)%mod;
        return (int)(res);
    }
}
