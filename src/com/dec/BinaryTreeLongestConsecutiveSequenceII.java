package com.dec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BinaryTreeLongestConsecutiveSequenceII {
    public static void main(String[] args) {
        TreeNodeII root = new TreeNodeII(1);
        root.left = new TreeNodeII(2);
        root.right = new TreeNodeII(3);
        int res = longestConsecutiveII(root);
        System.out.println(res);
    }

    private static int longestConsecutiveII(TreeNodeII root) {
        List<Integer> list = new ArrayList<>();
        longestConsecutiveIIHelper(root, list);
        System.out.println(list);
        //check for increasing and decresing
        int res = 1;
        int incLen = 1;
        int decLen = 1;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)+1==list.get(i+1)){
                incLen +=1;
                res = Math.max(res, incLen);
            } else {
                incLen =1;
            }
            if(list.get(i)-1 == list.get(i+1)){
                decLen +=1;
                res = Math.max(res, decLen);
            }else {
                decLen =1;
            }
        }
        return res;
    }

    private static void longestConsecutiveIIHelper(TreeNodeII root, List<Integer> list) {
        //base condition
        if(root == null) return;
        longestConsecutiveIIHelper(root.left,list);
        list.add(root.val);
        longestConsecutiveIIHelper(root.right,list);
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
