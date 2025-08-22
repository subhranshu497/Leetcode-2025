package com.august;

public class CountSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int [][] mat = {{1,0,1},{1,1,0},{1,1,0}};
        int count = numSubmat(mat);
        System.out.println(count);
    }

    private static int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int res =0;
        for(int sr=0;sr<m;sr++){
            int [] colRes = new int[n];
            for (int i = 0; i < n; i++) colRes[i] = 1;
            for(int er=sr;er<m;er++){
                for(int col=0;col<n;col++){
                    colRes[col] = colRes[col] & mat[er][col];
                }
                res +=oneDarrCount(colRes);
            }
        }
        return res;
    }

    private static int oneDarrCount(int[] arr) {
        int count =0;
        int res =0;
        for(int num : arr){
            if(num==1)
                count +=1;
            else count=0;
            res +=count;
        }
        return res;
    }
}
