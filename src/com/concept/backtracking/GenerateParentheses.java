package com.concept.backtracking;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n =3;
        List<String> res = generateParentheses(n);
        System.out.println(res);
    }

    private static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesesbacktracking(n,res, sb,0, 0);
        return res;
    }

    private static void generateParenthesesbacktracking(int n, List<String> res, StringBuilder sb, int openCount, int closeCount) {
        //base condition
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }
        if(openCount<n){
            sb.append('(');
            generateParenthesesbacktracking(n,res,sb,openCount+1, closeCount);
            sb.deleteCharAt(sb.length()-1);
        }
         if(closeCount<openCount){
             sb.append(')');
            generateParenthesesbacktracking(n,res,sb,openCount, closeCount+1);
             sb.deleteCharAt(sb.length()-1);
        }
    }
}
