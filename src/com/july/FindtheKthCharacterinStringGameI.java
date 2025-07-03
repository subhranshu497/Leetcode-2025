package com.july;

public class FindtheKthCharacterinStringGameI {
    public static void main(String[] args) {
        int k =5;
        char ch = kthCharacter(k);
        System.out.println(ch);
    }

    private static char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        char ch = 'a';
        sb.append(ch);
        while(sb.length()<k){
            StringBuilder sb1 = new StringBuilder();
            for (char c:sb.toString().toCharArray()){
                c = (char) (c+1);
                sb1.append(c);
            }
            sb = sb.append(sb1);
        }
        System.out.println(sb.toString());
        return sb.toString().charAt(k-1);
    }
}
