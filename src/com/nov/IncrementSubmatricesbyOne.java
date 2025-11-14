package com.nov;

public class IncrementSubmatricesbyOne {
    public static void main(String[] args) {
        int n = 3;
        int [][] queries = {{1,1,2,2},{0,0,1,1}};
        int [][] res = rangeAddQueries(queries,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+", ");
            }
            System.out.println();
        }
    }

    private static int[][] rangeAddQueries(int[][] queries, int n) {
        int [][] res = new int[n][n];
        for(int [] query:queries){
            int r1 = query[0];
            int c1 = query[1];
            int r2 = query[2];
            int c2 = query[3];

            for(int i=r1;i<=r2;i++){
                for(int j=c1;j<=c2;j++){
                    res[i][j] +=1;
                }
            }
        }
        return res;
    }
}
