package com.string;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        String res = mergeAlternately(word1, word2);
        System.out.println(res);
    }

    private static String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int i  =0;
        int j =0;
        while(i <n1 && j < n2){
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }
        if(i<n1){
            String sub1 = word1.substring(i, n1);
            sb.append(sub1);
        }else if(j<n2){
            String sub2 = word2.substring(j,n2);
            sb.append(sub2);
        }
        return sb.toString();
    }
}
