package com.july;

public class LargestBSTSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        int count = largestBSTSubtree(root);
        System.out.println(count);
    }

    private static int largestBSTSubtree(TreeNode root) {
        return largestBSTSubtreeHelper(root).nodeSize;
    }

    private static NodeValue largestBSTSubtreeHelper(TreeNode root) {
        //base condition
        if(root==null)
            return new NodeValue(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        //do post order traversal left right root
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        if(left.maxNode < root.val && root.val< right.minNode){
            int maxVal = Math.max(root.val, right.maxNode);
            int minVal = Math.min(root.val, left.minNode);
            int size = 1+ left.nodeSize+ right.nodeSize;

            return new NodeValue(size,maxVal,minVal);
        }
        int minVal1 = Integer.MIN_VALUE;
        int maxVal1 = Integer.MAX_VALUE;
        int size1 = Math.max(right.nodeSize, left.nodeSize);
        return new NodeValue(size1,maxVal1,minVal1);
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

class NodeValue{
     int nodeSize, maxNode, minNode;

    public NodeValue(int nodeSize, int maxNode, int minNode){
        this.nodeSize = nodeSize;
        this.maxNode = maxNode;
        this.minNode = minNode;
    }
}
