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

    private static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int i =1;
        boolean flag = true;
        res.add(1);
        while (res.size() <n){
            int prevNum = res.getLast();
            int nextNum = prevNum*10;
            if(nextNum <=n){
                res.add(nextNum);
                continue;
            }
            while (nextNum % 10 ==9 || nextNum+1 > n){
                nextNum /=10;
            }
            res.add(nextNum+1);
        }
    return res;
    }
}
