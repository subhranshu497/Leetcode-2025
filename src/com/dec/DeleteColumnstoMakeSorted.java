package com.dec;

public class DeleteColumnstoMakeSorted {
    public static void main(String[] args) {
        String [] strs = {"zyx","wvu","tsr"};
        int res = minDeletionSize(strs);
        System.out.println(res);
    }

    private static int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int m = strs.length;
        int j=0;
        int i =0;
        int res =0;
        char [] chararr = new char[m*n];
        int len = chararr.length;
        for(String str:strs){
            int count =0;
            while (count < n){
                chararr[i]= str.charAt(count);
                i++;
                count++;
            }
        }
        for(char ch:chararr)
            System.out.print(ch+", ");
        i=0;
        while(i<n){
            j = i+n;
            while(j<len){
                if(chararr[j]<chararr[j-n]){
                    res +=1;
                    break;
                }
                j +=n;
            }
            i++;
        }
        return res;
    }
}
