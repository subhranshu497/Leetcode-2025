package com.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaystoExpressanIntegerasSumofPowers {

    private static int MOD = 1000000007;
    public static void main(String[] args) {
        int n = 4;
        int x = 1;
        int ways = numberOfWays(n,x);
        System.out.println(ways);
    }

    private static int numberOfWays(int n, int x) {
        int ways =0;
        //precompute the power list
        List<Integer> powers = new ArrayList<>();
        for(int i=1;i<=n;i++){
            int power = (int) Math.pow(i,x);
            if(power<=n)
                powers.add(i);
        }
        //using dp
        int m = powers.size();
        int [] dp = new int[n+1];
        dp[0] =1;
        for(int i=1;i<m;i++){
            for(int j=0;j<i;j++){
                int sum = (int) Math.pow(powers.get(j),x) + (int) Math.pow(powers.get(i),x);
                if(sum==n)dp[i] +=1;
            }
        }
//        int [][] memo = new int[n+1][n+1];
//        for(int [] arr:memo)
//            Arrays.fill(arr,-1);
//        ways = (calculateWaysForPower(powers, n,x,0,0, memo)%MOD);
        return dp[m-1];
    }

    private static int calculateWaysForPower(List<Integer> powers, int n, int x, int i, int sum, int [][] memo) {

        //base condition
        if(sum==n ){
            return 1;
        }
        if(sum >n || i>=powers.size())
            return 0;
        if(memo[i][sum] !=-1) return memo[i][sum];

        //in case of take
        int take = (calculateWaysForPower(powers,n,x,i+1,(int)(sum+Math.pow(powers.get(i),x)), memo)%MOD);
        int skip = (calculateWaysForPower(powers,n,x, i+1,sum, memo)%MOD);
        return memo[i][sum]=(take+skip)%MOD;
    }
}
