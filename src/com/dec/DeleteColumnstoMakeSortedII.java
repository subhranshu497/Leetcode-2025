package com.dec;

public class DeleteColumnstoMakeSortedII {
    public static void main(String[] args) {
        String [] strs = {"xc","yb","za"};
        int res = minDeletionSizeI(strs);
        System.out.println(res);
    }

    private static int minDeletionSizeI(String[] strs) {
        int res =0;
        int rows = strs.length;;
        int cols = strs[0].length();
        boolean [] sorted = new boolean[rows-1];
        for(int col =0;col<cols;col++){
            boolean needToDelete = false;
            for(int row =0;row<rows-1;row++){
                if(!sorted[row] && strs[row].charAt(col)>strs[row+1].charAt(col)){
                    needToDelete = true;
                    res++;
                    break;
                }
            }
            if(needToDelete)continue;
            for (int i = 0; i < rows - 1; i++) {
                sorted[i] = sorted[i] ||
                        (strs[i].charAt(col) < strs[i + 1].charAt(col));
            }
        }
        return res;
    }
}
