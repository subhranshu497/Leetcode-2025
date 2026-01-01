package com.tree;

public class BinaryTreeLongestConsecutiveSequence {
    private static int res = 0;
    public static void main(String[] args) {
        TreeNodeI root = new TreeNodeI(1);
        root.right = new TreeNodeI(3);
        root.right.left = new TreeNodeI(2);
        root.right.right = new TreeNodeI(4);
        root.right.right.right = new TreeNodeI(5);
        int res = longestConsecutiveI(root);
        System.out.println(res);
    }

    private static int longestConsecutiveI(TreeNodeI root) {
        if(root==null) return 0;
        longestConsecutiveHelper(root, 0, root.val);
        return res;
    }

    private static void longestConsecutiveHelper(TreeNodeI root, int currLength, int target) {
        //base condition
        if(root==null)return;
        if(root.val==target)currLength +=1;
        else currLength =1;
        res = Math.max(res, currLength);
        longestConsecutiveHelper(root.left,currLength, root.val+1);
        longestConsecutiveHelper(root.right,currLength, root.val+1);
    }
}
