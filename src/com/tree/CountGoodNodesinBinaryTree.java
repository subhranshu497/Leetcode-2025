package com.tree;

public class CountGoodNodesinBinaryTree {
    private static int res = 0;
    public static void main(String[] args) {
        TreeNodeI root = new TreeNodeI(3);
        root.left = new TreeNodeI(1);
        root.right = new TreeNodeI(4);
        root.right.left = new TreeNodeI(1);
        root.right.right = new TreeNodeI(5);
        root.left.left = new TreeNodeI(3);
        int count = goodNodes(root);
        System.out.println(count);
    }

    private static int goodNodes(TreeNodeI root) {
        goodNodesHelper(root, 0, root.val);
        return res;
    }

    private static void goodNodesHelper(TreeNodeI root, int count, int max) {
        if(root==null) return;
        if(root.val>=max){
            max = root.val;
            res +=1;
        }
       // res = Math.max(res, count);
        goodNodesHelper(root.left,count, max);
        goodNodesHelper(root.right,count, max);
    }
}

