package com.july;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x =4, y =5;
        int score = maximumGain(s, x,y);
        System.out.println(score);
    }

    private static int maximumGain(String s, int x, int y) {
        return  (x>y)?maximumGainSolve(s, 'a', 'b',x,'b','a', y):
                maximumGainSolve(s,'b','a', y,'a','b',x);
    }

    private static int maximumGainSolve(String s,char high1, char high2,int x, char low1, char low2,int y) {
        int score =0;
        Stack<Character> firstStack = new Stack<>();
        for(char c:s.toCharArray()){
            if(!firstStack.isEmpty() && firstStack.peek()==high1 && c==high2){
                firstStack.pop();
                score +=x;
            }else firstStack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!firstStack.isEmpty()){
            sb.append(firstStack.pop());
        }
        String s1 = sb.reverse().toString();
        for(char c:s1.toCharArray()){
            if(!firstStack.isEmpty() && firstStack.peek()==low1 && c==low2){
                firstStack.pop();
                score +=y;
            }else firstStack.push(c);
        }
        return score;
    }
}
