package com.july;

public class ValidWord {
    public static void main(String[] args) {
        String word = "234Adas";
        boolean flag = isValidI(word);
        System.out.println(flag);
    }

    private static boolean isValidI(String word) {
        if(word.length()<3) return false;
        int vowels = 0;
        int consonants =0;
        //check for consonant and number
        for(char ch:word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)) return false;
            if(Character.isLetter(ch)){
                char lower = Character.toLowerCase(ch);
                if(lower=='a'||lower=='e'||lower=='i'||lower=='o'||lower=='u')vowels++;
                else consonants++;
            }
        }
        return (vowels>0 && consonants>0)?true:false;
    }
}
