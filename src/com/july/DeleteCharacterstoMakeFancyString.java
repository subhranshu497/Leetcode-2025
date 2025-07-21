package com.july;

public class DeleteCharacterstoMakeFancyString {
    public static void main(String[] args) {
        String res = makeFancyString("leeetcode");
        System.out.println(res);
    }

    private static String makeFancyString(String s) {
        int n = s.length();
        if(n==1 || n==2) return s;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==0 || i==1){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)==s.charAt(i-1) && s.charAt(i-1)==s.charAt(i-2)
                    && s.charAt(i)==s.charAt(i-2)){
                //continue;
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
