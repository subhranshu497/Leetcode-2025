package com.july;

public class FindtheKthCharacterinStringGameII {
    public static void main(String[] args) {
        long k = 10;
        int [] operations = {0,1,0,1};
        char ch = kthCharacterII(k, operations);
        System.out.println(ch);
    }

    private static char kthCharacterII(long k,int[] operations) {
        //0 - append the same string
        //1 - append the next string
        //base condition
        if(k==1) return 'a';
        int n = operations.length;
        long len =1;
        long newK = -1;
        int opType =-1;
        for(int i=0;i<n;i++){
            len *=2;
            if(len>=k){
                opType = operations[i];
                newK = k-(len/2);
                break;
            }
        }
        char ch = kthCharacterII(newK, operations);

        if(opType==0)
            return ch;
        else{
            if(ch=='z')return 'a';
            return (char)(ch+1);
        }
    }
}
