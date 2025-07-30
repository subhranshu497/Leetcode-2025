package com.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinarySearchTreeValueII {
    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(4);
//        int k =1;
//        double target = 0.000000 ;
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(5);
        root.left.left = new TreeNode2(1);
        root.left.right = new TreeNode2(3);
        double target = 3.714286;
        int k =2;
        List<Integer> res = closestKValues(root, target, k);
        System.out.println(res);

    }

    private static List<Integer> closestKValues(TreeNode2 root, double target, int k) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderTraversal(root, inOrderList);
        //to Store the result
        List<Integer> resultList = new ArrayList<>();
        //edge case
        if(k==0 || inOrderList.isEmpty()) return resultList;
        //find the point
        int p =0;
        while (p<inOrderList.size() && target>inOrderList.get(p))
            p++;
        int left  = p-1;
        int right =p;
        while(resultList.size()<k){
            if(left<0){
                resultList.add(inOrderList.get(right));
                right++;
            }else if(right >=inOrderList.size()){
                resultList.add(inOrderList.get(left));
                left--;
            }else {
                double diffLeft = Math.abs(inOrderList.get(left) - target);
                double diffRight = Math.abs(inOrderList.get(right) - target);

                if (diffLeft < diffRight) {
                    resultList.add(inOrderList.get(left));
                    left--;
                } else {
                    resultList.add(inOrderList.get(right));
                    right++;
                }
            }
        }
        return resultList;
    }

    private static void inOrderTraversal(TreeNode2 root, List<Integer> inOrderList) {
        //base condition
        if(root==null)return;
        inOrderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrderTraversal(root.right, inOrderList);
    }
}
class TreeNode2{
    TreeNode2 left;
    TreeNode2 right;
    int val;
    TreeNode2(int val){
        this.val = val;
    }
}
