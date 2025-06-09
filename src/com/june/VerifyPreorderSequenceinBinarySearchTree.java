package com.june;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class VerifyPreorderSequenceinBinarySearchTree {
    public static void main(String[] args) {
        int [] preOrder = {2,1};
        boolean flag = verifyPreorder(preOrder);
        System.out.println(flag);
    }

    private static boolean verifyPreorder(int [] preOrder) {
        int n = preOrder.length;
        Stack<Integer> st = new Stack<>();
        List<Integer> res = new LinkedList<>();
        st.push(preOrder[0]);
        int i =1;
        while(!st.isEmpty() && i<n){
            while(!st.isEmpty() && st.peek()<preOrder[i]){
                res.add(st.pop());
            }
                st.push(preOrder[i]);
            i++;
        }
        int currSize = res.size();
        while(!st.isEmpty())
            res.add(currSize++,st.pop());
        for(int j=1;j<n;j++){
            if(res.get(j)<res.get(j-1)) return false;
        }
        return true;
    }
}

