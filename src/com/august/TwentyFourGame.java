package com.august;

import java.util.ArrayList;
import java.util.List;

public class TwentyFourGame {
    public static void main(String[] args) {
        int [] cards ={1,2,1,2};
        boolean flag = judgePoint24(cards);
        System.out.println(flag);
    }
    private static boolean judgePoint24(int[] cards) {
        List<Double> cardsConverted = new ArrayList<>();
        for(int i=0;i<4;i++)
            cardsConverted.add((double) cards[i]);
        return twentyFourIsPossible(cardsConverted);
    }

    private static boolean twentyFourIsPossible(List<Double> cardsConverted) {
        //base condition
        // when cardsConvertd size ==1 and its val is 24 , return true
        int n = cardsConverted.size();
        if(cardsConverted.size()==1){
            return Math.abs(cardsConverted.get(0)-24.0)<1e-6;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;
                double firstNum = cardsConverted.get(i);
                double secondNum = cardsConverted.get(j);
                List<Double> validOps = getValidOpreations(firstNum, secondNum);
                List<Double> nextList = new ArrayList<>();
                for(double validOp:validOps){
                    nextList.clear();
                    nextList.add(validOp);
                    for(int k=0;k<n;k++){
                        if(k==i || k==j) continue;
                        nextList.add(cardsConverted.get(k));
                    }
                    if(twentyFourIsPossible(nextList)) return true;
                }
            }
        }
        return false;
    }

    private static List<Double> getValidOpreations(double firstNum, double secondNum){
        List<Double> validOps = new ArrayList<>();
        validOps.add(firstNum+secondNum);
        validOps.add(firstNum-secondNum);
        validOps.add(secondNum-firstNum);
        validOps.add(firstNum*secondNum);
        if(secondNum !=0)
            validOps.add(firstNum/secondNum);
        if(firstNum !=0)
            validOps.add(secondNum/firstNum);
        return validOps;
    }
}
