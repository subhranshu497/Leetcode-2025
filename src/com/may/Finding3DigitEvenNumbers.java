package com.may;

import java.util.*;

public class Finding3DigitEvenNumbers {
    public static void main(String[] args) {
        int [] digits = {2,1,3,0};
        int [] result = findEvenNumbers(digits);
        for(int res:result)
            System.out.print(res+", ");
    }

    private static int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        int [] count = new int[10];
        List<Integer> list = new ArrayList<>();
        for(int num:digits)
            count[num]++;
        for(int i=1;i<=9;i++){
            if(count[i]==0) continue;
            count[i]--;
            for(int j=0;j<=9;j++){
                if(count[j]==0) continue;
                count[j]--;
                for(int k=0;k<=8;k+=2){
                    if(count[k]==0) continue;
                    count[k]--;
                    int num = (i*100)+(j*10)+k;
                    list.add(num);
                    count[k]++;
                }
                count[j]++;
            }
            count[i]++;
        }
        int idx=0;
        int[] res = new int[list.size()];
        for(int r:list){
            res[idx++] = r;
        }
        return res;
    }

    private static void solve2(int[] digits, List<Integer> list,StringBuilder sb, int n, int i) {

        //base condition
        if(i<n && sb.length()==3){
            int num = Integer.parseInt(sb.toString());
            if(num % 2 ==0){
                list.add(num);
            }
            sb = new StringBuilder();
        }
        sb.append(digits[i]);
        solve2(digits, list, sb,n,i+1);
    }
}
