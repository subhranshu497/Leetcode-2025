package com.dec;

public class CounttheNumberofComputerUnlockingPermutations {
    private static int mod = 1000000007;
    public static void main(String[] args) {
        int [] complexity = {1,2,3};
        int count = countPermutations(complexity);
        System.out.println(count);
    }

    private static int countPermutations(int[] complexity) {
        int n = complexity.length;
        long ans = 1;
        for(int i=1;i<n;i++){
            if(complexity[i]<=complexity[0])return 0;
        }
        for(int i=1;i<n;i++){
            ans = (ans*i)%mod;
        }
        return (int)ans;
    }
}
