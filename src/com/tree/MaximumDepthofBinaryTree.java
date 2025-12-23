package com.tree;

import javax.swing.tree.TreeNode;

public class MaximumDepthofBinaryTree {
    private static int res;
    public static void main(String[] args) {
        TreeNodeI root = new TreeNodeI(3);
        root.left = new TreeNodeI(9);
        root.right = new TreeNodeI(20);
        root.right.left = new TreeNodeI(15);
        root.right.right = new TreeNodeI(7);
        int depth = maxDepthI(root);
        System.out.println(depth);
    }

    private static int maxDepthI(TreeNodeI root) {
        maxDepthDfsHelper(root, 0);
        return res;
    }

    private static void maxDepthDfsHelper(TreeNodeI root, int depth) {
        //base condition
        if(root==null){
            res = Math.max(res, depth);
            return;
        }
        maxDepthDfsHelper(root.left, depth+1);
        maxDepthDfsHelper(root.right, depth+1);
    }
}
class TreeNodeI{
    int val;
    TreeNodeI left;
    TreeNodeI right;
    public TreeNodeI(int val){
        this.val = val;
    }
}
