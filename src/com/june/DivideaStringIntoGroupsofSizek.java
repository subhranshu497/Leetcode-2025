package com.june;

public class DivideaStringIntoGroupsofSizek {
    public static void main(String[] args) {
        String s = "abcdefghij";
        int k =3;
        char fill = 'x';
        String [] res = divideString(s,k, fill);
        for(String str:res)
            System.out.print(str+", ");
    }

    private static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int m = n/k;
        if(n%k !=0) m +=1;
        String [] res = new String[m];
        int j=0;
        for(int i=0;i<n;i +=k){
            int st = i;
            int end = st+k;
            String sub ="";
            if(end >n){
                sub = s.substring(st, n);
                int delta = end-n;
                StringBuilder sb = new StringBuilder();
                while(delta >0){
                    sb.append(fill);
                    delta--;
                }
                sub +=sb.toString();
            }else{
                 sub = s.substring(st, end);
            }
            res[j] =sub;
            j++;
        }
        return res;
    }
}
