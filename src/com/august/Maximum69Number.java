package com.august;

public class Maximum69Number {
    public static void main(String[] args) {
        int num = 9669;
        int op = maximum69Number(num);
        System.out.println(op);
    }

    private static int maximum69Number(int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        boolean flag = true;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='6' && flag){
                sb.append('9');
                flag =false;
            }
            else sb.append(ch);
        }
        return Integer.parseInt(sb.toString());
    }
}
