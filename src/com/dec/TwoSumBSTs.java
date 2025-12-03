package com.dec;

import java.util.*;

public class TwoSumBSTs {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(-10);
        root1.right = new TreeNode(10);
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(2);
        root2.right = new TreeNode(7);
        int target = 18;
        boolean flag = twoSumBSTs(root1, root2, target);
        System.out.println(flag);
    }

    private static boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //find inorder traversal of root1
        inorderTraversalOfBST(root1, set1);
        inorderTraversalOfBST(root2, set2);
        System.out.println(set1);
        System.out.println(set2);
        for(int num:set1){
            int inv = target-num;
            if(set2.contains(inv))return true;
        }
        return false;
    }

    private static void inorderTraversalOfBST(TreeNode root, Set<Integer> set) {
        //base case
        if(root==null)return;
        inorderTraversalOfBST(root.left, set);
        set.add(root.val);
        inorderTraversalOfBST(root.right, set);
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
