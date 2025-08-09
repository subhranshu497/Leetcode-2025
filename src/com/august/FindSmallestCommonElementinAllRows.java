package com.august;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class FindSmallestCommonElementinAllRows {
    public static void main(String[] args) {
        int [][] mat = {{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
        int res = smallestCommonElement(mat);
        System.out.println(res);
    }

    private static int smallestCommonElement(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Set<Integer> set1 = new HashSet<>();
        int i=0;
        for(i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                set1.add(mat[i][j]);
            }
            break;
        }
        Set<Integer> set2 = new HashSet<>();
        for(i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(set1.contains(mat[i][j])){
                    set2.add(mat[i][j]);
                }
            }
            set1 = set2;
            set2 = new HashSet<>();
        }
        int res = Integer.MAX_VALUE;
        for(int num:set1){
            res = Math.min(res, num);
        }
        return res ==Integer.MAX_VALUE?-1:res;
    }
}
