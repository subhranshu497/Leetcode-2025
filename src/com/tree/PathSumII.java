package com.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static void main(String[] args) {
        TreeNodeI root = new TreeNodeI(5);
        root.left = new TreeNodeI(4);
        root.right = new TreeNodeI(8);
        root.left.left = new TreeNodeI(11);
        root.left.left.left = new TreeNodeI(7);
        root.left.left.right = new TreeNodeI(2);
        root.right.left = new TreeNodeI(13);
        root.right.right = new TreeNodeI(4);
        root.right.right.left = new TreeNodeI(5);
        root.right.right.right = new TreeNodeI(1);
        int targetSum = 22;
        List<List<Integer>> res= pathSum(root, targetSum);
        System.out.println(res);
    }

    private static List<List<Integer>> pathSum(TreeNodeI root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        int sum =0;
        pathSumHelperII(root,sum, targetSum, new ArrayList<>(),res);
        return res;
    }

    private static void pathSumHelperII(TreeNodeI root, int sum, int targetSum, List<Integer> ds, List<List<Integer>> res) {
        //base condition
        if(root==null) return;
        sum +=root.val;
        ds.add(root.val);
        if(root.left==null && root.right==null){
            if(targetSum==sum){
                res.add(new ArrayList<>(ds));
            }
        }
        pathSumHelperII(root.left,sum, targetSum, ds,res);
        pathSumHelperII(root.right,sum,targetSum,ds, res);
        ds.removeLast();
    }
}
