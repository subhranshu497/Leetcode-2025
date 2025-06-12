package com.frequentlyAsked;

import java.util.*;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/user/Documents/../Pictures";
        String op = simplifyPath(path);
        System.out.println("op  "+op);
    }

    private static String simplifyPath(String path) {
        if(path.startsWith("/")) path = path.substring(1);
        StringBuilder sb = new StringBuilder();
        String [] pathArr = path.split("/");
        int n = pathArr.length;
        System.out.println(pathArr.length);
        for(String p:pathArr)
            System.out.print(p+", ");
        System.out.println();
        Stack<String> q = new Stack<>();
//        if(!pathArr[0].equals(".."))
//            q.addFirst(pathArr[0]);
        for(int i=0;i<n;i++)
        {
            String s = pathArr[i];
            if(s.equals(".") || s.equals(""))continue;
            if(!s.equals(".."))q.addFirst(s);
            else if(!q.isEmpty())q.removeFirst();
        }
        while (!q.isEmpty()){
            String curr = q.removeLast();
            sb.append("/");
            sb.append(curr);
        }
        if(sb.isEmpty())sb.append("/");
        return sb.toString();
    }

//    private static String simplifyPath(String path) {
//        int n = path.length();
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        int j = 0;
//        while(i<n){
//            char ch = path.charAt(i);
//            if(ch=='/' && j !=n-1){
//
//                //j =i+1;
//                StringBuilder tempSb = new StringBuilder();
//                while(j<n && path.charAt(j) !='/'){
//                    if(path.charAt(j-1)=='/') tempSb.append('/');
//                    tempSb.append(path.charAt(j));
//                    j++;
//                }
//                if(tempSb.toString().equals("///")){
//                    sb.append('/');
//                }
//                else if(tempSb.toString().equals("//")){
//                    sb.append('/');
//                }else if(tempSb.toString().equals(".")){
//                    String s = sb.toString();
//                    String sub = s.substring(0, s.length()-1);
//                    sb = new StringBuilder(sub);
//                    continue;
//                }else if(tempSb.toString().equals("/..")){
//                    String s = sb.toString();
//                    if(s.length()!=0) {
//                        int k =s.length()-1;
//                        for(k = s.length()-1;k>=0;k--){
//                            if(s.charAt(k) =='/'){
//                                break;
//                            }
//                        }
//                        String sub = s.substring(0, k);
//                        sb = new StringBuilder(sub);
//                    }
//
//                }else {
//                    sb.append(tempSb);
//                }
//                i=j;
//                //sb.append(path.charAt(i));
//            }
//            j=i+1;
//        }
//        return sb.toString();
//    }
}
