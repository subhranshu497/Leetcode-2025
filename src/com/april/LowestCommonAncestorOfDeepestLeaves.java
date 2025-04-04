package com.april;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorOfDeepestLeaves {

    public static Map<Integer, Integer> map = new HashMap<>(); // node number as key , depth as value
    public static int maxDepth =0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode res= lcaDeepestLeaves(root);

        printTreeNode(res);

    }

    private static void printTreeNode(TreeNode root) {
        if(root == null) return;
        printTreeNode(root.left);
        System.out.print(root.val+", ");
        printTreeNode(root.right);
    }

    private static TreeNode lcaDeepestLeaves(TreeNode root) {
        calculateDepth(root,0);
        return lca(root);
    }

    private static TreeNode lca(TreeNode root) {
        if(root ==null || map.getOrDefault(root.val, -1)==maxDepth)
            return root;
        TreeNode ln = lca(root.left);
        TreeNode rn = lca(root.right);

        if(ln != null && rn !=null)
            return root;

        return ln != null? ln:rn;
    }

    private static void calculateDepth(TreeNode root, int depth) {
        if(root == null) return;
        maxDepth = Math.max(maxDepth, depth);
        map.put(root.val, depth);
        calculateDepth(root.left, depth+1);
        calculateDepth(root.right, depth+1);
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(TreeNode left, TreeNode right, int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
