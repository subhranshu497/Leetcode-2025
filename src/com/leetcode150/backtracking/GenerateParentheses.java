package com.leetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n =3;
        List<String> res= generateParenthesis(n);
        System.out.println(res);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int open =0;
        int close =0;
        parenthesisGenerator(res, n, sb, open, close);
        return res;
    }

    private static void parenthesisGenerator(List<String> res, int n, StringBuilder sb, int open, int close) {
        //basecase
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }
        if(open < n){
            sb = sb.append("(");
            parenthesisGenerator(res, n,sb, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb = sb.append(")");
            parenthesisGenerator(res, n,sb, open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }


    }
}
