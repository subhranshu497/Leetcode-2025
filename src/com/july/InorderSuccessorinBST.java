package com.july;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorinBST {
    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(5);
        root.left = new TreeNode1(3);
        root.right = new TreeNode1(6);
        root.left.left = new TreeNode1(2);
        root.left.right = new TreeNode1(4);
        root.left.left.left = new TreeNode1(1);

        TreeNode1 p = new TreeNode1(6);

        TreeNode1 ans = inorderSuccessor(root, p);
        System.out.println(ans.val);
    }

    private static TreeNode1 inorderSuccessor(TreeNode1 root, TreeNode1 p) {
        List<TreeNode1> inOrderList = new ArrayList<>();
        inorderTraversalBST(root, inOrderList);
        //if root.val <= p.val - the next node in the inorder list would be the ans
        //if roo.val > p.val - the prev node in the inorder list would be the ans
        int n = inOrderList.size();
        for(int i=0;i<n;i++){
            if(inOrderList.get(i).val==p.val){
                    if(i+1 < n){
                        return inOrderList.get(i+1);
                    }else return null;

            }
        }
        return null;
    }

    private static void inorderTraversalBST(TreeNode1 root, List<TreeNode1> inOrderList) {
        //base condition
        if(root==null)return;

        inorderTraversalBST(root.left, inOrderList);
        inOrderList.add(root);
        inorderTraversalBST(root.right, inOrderList);
    }
}
  class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1(int x) { val = x; }
  }
