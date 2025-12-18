package com.dec;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLongestConsecutiveSequence {
    private static int max = 0;
    public static void main(String[] args) {
        TreeNodeI root = new TreeNodeI(1);
        root.right = new TreeNodeI(3);
        root.right.left = new TreeNodeI(2);
        root.right.right = new TreeNodeI(4);
        root.right.right.right = new TreeNodeI(5);
        int res = longestConsecutive(root);
        System.out.println(res);
    }

    private static int longestConsecutive(TreeNodeI root) {
        if(root == null) return 0;
        treeTraversalHelper(root, 0, root.val);
        return max;
    }

    private static void treeTraversalHelper(TreeNodeI root, int curr, int target) {
        //base condition
        if(root == null) return;
        if(root.val==target) curr++;
        else curr =1;
        max = Math.max(max, curr);
        treeTraversalHelper(root.left,curr, root.val+1);
        treeTraversalHelper(root.right, curr, root.val+1);
    }
}
class TreeNodeI{
    TreeNodeI left;
    TreeNodeI right;
    int val;
    public TreeNodeI(){

    }
    public TreeNodeI(TreeNodeI left, TreeNodeI right, int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
    public TreeNodeI(int val){
        this.val = val;
    }
}
