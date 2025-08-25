package com.august;

import java.util.*;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int [] res = findDiagonalOrder(matrix);
        for(int num:res)
            System.out.print(num+", ");
    }

    private static int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.computeIfAbsent(i+j, k-> new LinkedList<>()).add(matrix[i][j]);
            }
        }
        System.out.println(map);
        int [] res = new int[m*n];
        //now iterate the map
        int j=0;
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            int key = e.getKey();
            List<Integer> list = e.getValue();
            if(key % 2 ==0){
                for(int i=list.size()-1;i>=0;i--){
                    res[j] =list.get(i);
                    j++;
                }
            }else {
                for(int i=0;i<list.size();i++){
                    res[j] =list.get(i);
                    j++;
                }
            }
        }
        return res;
    }
}
