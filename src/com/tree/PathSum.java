package com.tree;

public class PathSum {
    public static void main(String[] args) {
        TreeNodeI root = new TreeNodeI(5);
        root.left = new TreeNodeI(4);
        root.right = new TreeNodeI(8);
        root.right.left = new TreeNodeI(13);
        root.right.right = new TreeNodeI(4);
        root.right.right.right = new TreeNodeI(1);
        root.left.left = new TreeNodeI(11);
        root.left.left.left = new TreeNodeI(7);
        root.left.left.right = new TreeNodeI(2);
        int targetSum = 22;
        boolean flag = hasPathSum(root, targetSum);
        System.out.println(flag);
    }

    private static boolean hasPathSum(TreeNodeI root, int targetSum) {
        return hasPathSumHelper(root,targetSum);
    }

    private static boolean hasPathSumHelper(TreeNodeI root, int targetSum) {
        //base condition
        if(root==null) return false;
        if(root.left==null && root.right==null)
            return targetSum==root.val;

        boolean leftSum = hasPathSumHelper(root.left, targetSum- root.val);
        boolean rightSum = hasPathSumHelper(root.right,targetSum- root.val);
        return leftSum || rightSum;
    }
}
