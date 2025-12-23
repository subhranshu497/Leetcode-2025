package com.tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNodeI root1 = new TreeNodeI(1);
        root1.left = new TreeNodeI(2);
        root1.right = new TreeNodeI(200);

        TreeNodeI root2 = new TreeNodeI(1);
        root2.left = new TreeNodeI(2);
        root2.right = new TreeNodeI(200);
        boolean flag = leafSimilar(root1, root2);
        System.out.println(flag);
    }

    private static boolean leafSimilar(TreeNodeI root1, TreeNodeI root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        leafSimilarDFS(root1, list1);
        leafSimilarDFS(root2, list2);
        System.out.println(list1 +"   "+list2);
        if(list1.size() != list2.size())
            return false;
        for(int i =0;i<list1.size();i++){
            int num1 = list1.get(i);
            int num2 = list2.get(i);
            if(num1 != num2)
                return false;
        }
        return true;
    }

    private static void leafSimilarDFS(TreeNodeI root, List<Integer> list) {
        if(root==null) return;
        if(root.left==null && root.right==null)
            list.add(root.val);
        leafSimilarDFS(root.left,list);
        leafSimilarDFS(root.right,list);
    }
}
