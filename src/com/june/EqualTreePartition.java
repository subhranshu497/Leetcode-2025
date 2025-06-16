package com.june;

import java.util.LinkedList;
import java.util.Queue;

public class EqualTreePartition {
    private static boolean flag = false;
    private static int totalSum=0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(-1);
//        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(3);
        boolean flag = checkEqualTree(root);
        System.out.println(flag);
    }

    private static boolean checkEqualTree(TreeNode root) {
        totalSum = calculateSumDfs(root);
        if(totalSum %2 !=0) return false;
        checkForHalfTree(root);
        return flag;
    }

    private static int checkForHalfTree(TreeNode root) {

        //base condition
        if(root == null) return 0;
        if(flag) return 0;

        int left = checkForHalfTree(root.left);
        int right = checkForHalfTree(root.right);

        if(root.left != null){
            int sum =totalSum- left;
            if(sum == left){
                flag = true;
                return 0;
            }
        }
        if(root.right != null){
            int sum =totalSum- right;
            if(sum == right){
                flag = true;
                return 0;
            }
        }
        return root.val+left+right;
    }

    private static int calculateSumDfs(TreeNode root) {
        //base condition
        if(root == null){
            return 0;
        }
        int left = calculateSumDfs(root.left);
        int right = calculateSumDfs(root.right);

        return left+right+root.val;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){
    }
    TreeNode (int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
