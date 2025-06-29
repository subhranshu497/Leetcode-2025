package com.june;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

    static Node head;
    static Node tail;
    public static void main(String[] args) {
        Node root = new Node();
        Node node = treeToDoublyList(root);
    }
    public static Node treeToDoublyList(Node root) {
        if(root==null)
            return null;
        inorderTraversal(root);
        tail.right = head;
        head.left = tail;
        return head;
    }
    private static void inorderTraversal(Node root) {
        //base condition
        if(root == null)
            return;
        inorderTraversal(root.left);
        if (head == null){
            head = root;
        }
        if (tail != null) {
            tail.right = root;
            root.left = tail;
        }
        tail= root;
        inorderTraversal(root.right);
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
