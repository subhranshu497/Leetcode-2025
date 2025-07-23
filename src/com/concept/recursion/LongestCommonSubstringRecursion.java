package com.concept.recursion;

public class LongestCommonSubstringRecursion {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "geeksquiz";
        int ans = lcsRecursion(s1, s2);
        System.out.println(ans);
    }

    private static int lcsRecursion(String s1, String s2) {
        int ans= solveLCSRecursion(s1, s2, 0,0,0);
        return ans;
    }

    private static int solveLCSRecursion(String s1, String s2, int i, int j, int count) {
        //base condition
        if(i>=s1.length() || j>=s2.length())
            return count;
        int ans = count;
        //in case of matching
        if(s1.charAt(i) == s2.charAt(j))
            ans = solveLCSRecursion(s1,s2,i+1,j+1,count+1);
        //take s1 next char
        int takeS1 = solveLCSRecursion(s1,s2,i+1,j,count);
        int takeS2 = solveLCSRecursion(s1,s2, i, j+1,count);
        return Math.max(ans, Math.max(takeS2, takeS1));
    }
}
