package com.oct;

public class NumberofLaserBeamsinaBank {
    public static void main(String[] args) {
        String [] bank = {"000","111","000"};
        int noOfBeams = numberOfBeams(bank);
        System.out.println(noOfBeams);
    }

    private static int numberOfBeams(String[] bank) {
        int beams = 0;
        int prev =0;
       for(String s:bank){
           //count 1 in the string
           int curr= countOnes(s);
           if(curr !=0){
               beams +=prev*curr;
               prev = curr;
           }
       }
        return beams;
    }

    private static int countOnes(String s) {
        int count =0;
        for(char ch:s.toCharArray()){
            if(ch== '1')count++;
        }
        return count;
    }
}
