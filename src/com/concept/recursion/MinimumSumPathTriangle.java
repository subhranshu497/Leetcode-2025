package com.concept.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSumPathTriangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle
                = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3, 9)));
        triangle.add(new ArrayList<>(List.of(1, 6, 7)));
        int sum = minSumPath(triangle);
        System.out.println(sum);
    }

    private static int minSumPath(ArrayList<ArrayList<Integer>> triangle) {
        int [][] mem0 = new int[triangle.size()][triangle.size()];
        for(int [] a:mem0){
            Arrays.fill(a, -1);
        }
        int sum = solveMinSumPath(triangle,0,0, mem0);
        return sum;
    }

    private static int solveMinSumPath(ArrayList<ArrayList<Integer>> triangle, int i, int j,int [][] mem0) {
        //base condition
        if(i>=triangle.size())return 0;
        if(j>=triangle.get(i).size()) return 0;
        if(mem0[i][j] != -1) return mem0[i][j];
        //take j
        int takefirst = solveMinSumPath(triangle,i+1,j, mem0);
        int skipfirst = solveMinSumPath(triangle,i+1,j+1, mem0);

        return mem0[i][j] = triangle.get(i).get(j)+Math.min(takefirst, skipfirst);
    }
}
