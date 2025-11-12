package com.nov;

import java.util.Arrays;

public class OnesandZeroes {
    private static int ans;
    public static void main(String[] args) {
        String [] strs = {"10","0001","111001","1","0"};
        int m = 5 , n =3;
        int res = findMaxForm(strs, m,n);
        System.out.println(res);
    }

    private static int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int [][][] memo = new int[len+1][m+1][n+1];
        for(int [][] arr:memo)
            for(int [] a:arr)
                Arrays.fill(a, -1);
        int res = findMaxFormRecursion(strs, 0,0,0,0,m,n,len, memo);
        return res;
    }

    private static int findMaxFormRecursion(String[] strs, int i, int subLen, int zeroM, int oneN, int m, int n, int len, int [][][] memo) {
        //base condition
        if(i>=len) return 0;
        if(memo[i][zeroM][oneN] !=-1) return memo[i][zeroM][oneN];
        int [] zeroAndOne = countZeroAndOne(strs[i]);
        int take =0;
        if(zeroM+zeroAndOne[0] <= m && oneN+zeroAndOne[1] <= n)
            take = 1+findMaxFormRecursion(strs,i+1,subLen+1,zeroM+zeroAndOne[0],oneN+zeroAndOne[1],m,n,len, memo);
        int skip = findMaxFormRecursion(strs,i+1,subLen,zeroM,oneN,m,n,len, memo);

        return memo[i][zeroM][oneN]=Math.max(take, skip);
    }

    private static int[] countZeroAndOne(String s) {
        int [] res = new int[2];
       res[0] =(int) s.chars().filter(c->c=='0').count();
       res[1] =(int) s.chars().filter(c->c=='1').count();
        return res;
    }
}
