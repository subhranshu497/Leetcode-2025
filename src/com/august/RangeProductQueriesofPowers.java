package com.august;

import java.util.ArrayList;
import java.util.List;

public class RangeProductQueriesofPowers {

    private static long MOD = 1000000007;
    public static void main(String[] args) {
        int [][] queries = {{0,0}};
        int n = 2;
        int [] res = productQueries(n, queries);
        for(int num:res)
            System.out.print(num+", ");
    }

    private static int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        //form the power list
        for(int i=0;i<32;i++){
            //check if ith bit of n is set
            if((n & (1<<i)) !=0){
                powers.add(1<<i);
            }
        }
        //now the powers list - 1,2,4,8
        int[] res = new int[queries.length];
        int j=0;
        for(int [] query:queries){
            long prod =1;
            int start =query[0];
            int end = query[1];
            for(int i=start;i<=end;i++){
                prod = (int) ((prod*(powers.get(i)))%MOD);
            }
            res[j++] =(int) prod;
        }
        return res;
    }
}
