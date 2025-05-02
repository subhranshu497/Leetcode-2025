package com.may;

import java.util.Arrays;

public class PushDominoes {
    public static void main(String[] args) {
        String  dominoes = ".L.R...LR..L..";
        String result = pushDominoes(dominoes);
        System.out.println(result);
    }

    private static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int leftToRightR [] = new int [n];
        int rightToLeftL [] = new int [n];

        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R')
                leftToRightR[i]=i;
            else if(dominoes.charAt(i)=='.')
                leftToRightR[i]= i > 0?leftToRightR[i-1]:-1;
            else leftToRightR[i] = -1;
        }

        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L')
                rightToLeftL[i]=i;
            else if(dominoes.charAt(i)=='.')
                rightToLeftL[i]= i < n-1?rightToLeftL[i+1]:-1;
            else rightToLeftL[i] = -1;
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<n;i++){
                int distFromleftToR = leftToRightR[i] ==-1 ? Integer.MAX_VALUE : Math.abs((i-leftToRightR[i]));
                int distFromRightToL = rightToLeftL[i] ==-1 ? Integer.MAX_VALUE : Math.abs((i-rightToLeftL[i]));
            if(rightToLeftL[i] == leftToRightR[i])
                result.append('.');
            else if(rightToLeftL[i]== -1)
                result.append('R');
            else if(leftToRightR[i]== -1)
                result.append('L');
            else if(distFromleftToR== distFromRightToL)
                result.append('.');
            else
                result.append(distFromRightToL < distFromleftToR ? 'L':'R');
        }
        return result.toString();
    }
}
