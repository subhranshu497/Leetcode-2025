package com.concept.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidateBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println(validateBSt(root));
    }

    private static boolean validateBSt(TreeNode root) {
        long minVal = Long.MIN_VALUE;
        long maxVal = Long.MAX_VALUE;
        return validateBSTHelper(root, minVal, maxVal);
    }

    private static boolean validateBSTHelper(TreeNode root, long minVal, long maxVal) {
        //base condition
        if(root==null) return true;
        if(root.val >=maxVal || root.val <= minVal)return false;
        return validateBSTHelper(root.left, minVal, root.val)
                && validateBSTHelper(root.right, root.val, maxVal);
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
        this.right = right;
        this.left = left;
        this.val = val;
    }
}
