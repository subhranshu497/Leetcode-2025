package com.dec;

import javax.swing.plaf.IconUIResource;

public class DeleteColumnstoMakeSorted {
    public static void main(String[] args) {
        String [] strs = {"zyx","wvu","tsr"};
        int res = minDeletionSize(strs);
        System.out.println(res);
    }

    private static int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int count =0;
        for(int i=0;i<n;i++){
            for(int j =1;j<m;j++){
                if(strs[j].charAt(i) < strs[j-1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
