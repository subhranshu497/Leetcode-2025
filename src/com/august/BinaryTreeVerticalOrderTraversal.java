package com.august;

import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(3);
        root.left = new TreeNode2(9);
        root.right = new TreeNode2(20);
        root.right.left = new TreeNode2(15);
        root.right.right = new TreeNode2(7);
        List<List<Integer>> res = verticalOrderTraversal(root);
        System.out.println(res);
    }

    private static List<List<Integer>> verticalOrderTraversal(TreeNode2 root) {
        if(root== null) return new ArrayList<>();
        //to store horizontal distance from root node
        Map<TreeNode2, Integer> hdMap = new HashMap<>();
        hdMap.put(root, 0);
        //populate hdmap
        calculateHorizontalDistForNode(root,hdMap);
        System.out.println(hdMap);
        //do level order traversal and store all node values to a map based on their horizontal distance
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode2> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode2 current = q.poll();
            int hd = hdMap.get(current);
            map.computeIfAbsent(hd, k->new ArrayList<>()).add(current.val);
            if(current.left !=null)
                q.offer(current.left);
            if(current.right !=null)
                q.offer(current.right);
        }
        System.out.println(map);
        //do the traversal through the map and get the val
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> e:map.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }

    private static void calculateHorizontalDistForNode(TreeNode2 root, Map<TreeNode2, Integer> hdMap) {
        //base condition
        if(root == null)return;
        if(root.left != null){
            int val = hdMap.get(root);
            val -=1;
            hdMap.put(root.left, val);
        }
        calculateHorizontalDistForNode(root.left,hdMap);
        if(root.right != null){
            int val = hdMap.get(root);
            val +=1;
            hdMap.put(root.right, val);
        }
        calculateHorizontalDistForNode(root.right,hdMap);
    }

}
class NodeHorizontalDistance{
    int horizontalDistance;
    TreeNode2 node;
    public NodeHorizontalDistance(int horizontalDistance){
        this.horizontalDistance = horizontalDistance;
    }
}
class TreeNode2{
    int val;
    TreeNode2 left;
    TreeNode2 right;
    public TreeNode2(){}
    public TreeNode2(int val){
        this.val = val;
    }
    public TreeNode2(int val, TreeNode2 left, TreeNode2 right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
