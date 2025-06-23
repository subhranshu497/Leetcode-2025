package com.june;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LexicographicalNumbers {
    private static int exp= 0;
    public static void main(String[] args) {
        int n = 13;
        List<Integer> res = lexicalOrder(n);
        System.out.println(res);
    }

    //using recursion
    private static List<Integer> lexicalOrderI(int n) {
        List<Integer> res = new ArrayList<>();
        //we have to run a loop as we have to visiteach num and group by its digits
        for(int num=1;num<=9;num++){
            solveLexicalOrder(num,n, res);
        }
        return res;
    }

    private static void solveLexicalOrder(int num, int n, List<Integer> res) {
        //base condition
        if(num >n) return;
        res.add(num);
        //since we have to group all num start with num, i.e 1, 10, 11, 12 ,13...., 2,20, 21....
        for(int appendDigit=0;appendDigit<=9;appendDigit++){
            int nextNum = (num*10)+appendDigit;
            if(nextNum > n) return;
            solveLexicalOrder(nextNum, n, res);
        }
    }

    private static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() <n){
            int prevNum = res.getLast();
            int nextNum = prevNum*10;
            if(nextNum <=n){
                res.add(nextNum);
                continue;
            }
            while (nextNum+1 > n  ){
                nextNum /=10;
            }
            res.add(nextNum+1);
        }
    return res;
    }
}
