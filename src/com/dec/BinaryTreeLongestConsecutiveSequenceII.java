package com.dec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BinaryTreeLongestConsecutiveSequenceII {
    private static int res = 0;
    public static void main(String[] args) {
        TreeNodeII root = new TreeNodeII(1);
        root.left = new TreeNodeII(2);
        root.right = new TreeNodeII(3);
        int res = longestConsecutiveII(root);
        System.out.println(res);
    }

    private static int longestConsecutiveII(TreeNodeII root) {
        if(root==null) return 0;
        longestConsecutiveIIHelper(root);
        return res;
    }

    private static int[] longestConsecutiveIIHelper(TreeNodeII root) {
        if (root == null) {
            return new int[]{0,0};
        }
        int incr = 1, dcr = 1;
        int[] left = longestConsecutiveIIHelper(root.left);
        int[] right = longestConsecutiveIIHelper(root.right);
        // ans = Math.max(left[0] + right[1]+ 1, ans)
        if (root.left != null && root.val == root.left.val + 1) {
            incr = left[0] + 1;
        }
        if (root.right != null && root.val == root.right.val + 1) {
            incr = Math.max(incr, right[0] + 1);
        }
        if (root.left != null && root.val == root.left.val - 1) {
            dcr = left[1] + 1;
        }
        if (root.right != null && root.val == root.right.val - 1) {
            dcr = Math.max(dcr, right[1] + 1);
        }
        res = Math.max(res, dcr + incr - 1);
        return new int[]{incr, dcr};

    }
}
class TreeNodeII{
    int val;
    TreeNodeII left;
    TreeNodeII right;
    public TreeNodeII(int val){
        this.val = val;
    }
}
