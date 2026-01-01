package com.tree;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PathSumIII {
    private static int count=0;
    public static void main(String[] args) {
        TreeNodeI root = new TreeNodeI(10);
        root.left = new TreeNodeI(5);
        root.right = new TreeNodeI(-3);
        root.left.left = new TreeNodeI(3);
        root.left.right = new TreeNodeI(2);
        root.left.right.right = new TreeNodeI(1);
        root.left.left.left = new TreeNodeI(3);
        root.left.left.right = new TreeNodeI(-2);
        root.right.right = new TreeNodeI(11);
         int targetSum = 8;
         int res  = pathSumIII(root, targetSum);
        System.out.println(res);
    }

    private static int pathSumIII(TreeNodeI root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L,1);
        return pathSumIIIHelper(root, 0L, targetSum, prefixSumMap);
    }

    private static int pathSumIIIHelper(TreeNodeI root, long sum, int targetSum, Map<Long, Integer> prefixSumMap) {
        //base condition
        if(root==null)return 0;
        sum +=root.val;
        int count = prefixSumMap.getOrDefault(sum-targetSum,0);
        prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum,0)+1);
        count +=pathSumIIIHelper(root.left,sum,targetSum, prefixSumMap);
        count +=pathSumIIIHelper(root.right,sum,targetSum, prefixSumMap);
        prefixSumMap.put(sum, prefixSumMap.get(sum)-1);

        return count;
    }
}
