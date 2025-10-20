package com.oct;

import java.util.HashSet;
import java.util.Set;

public class FinalValueofVariableAfterPerformingOperations {
    public static void main(String[] args) {
        String [] opertains = {"--X","X++","X++"};
        int res = finalValueAfterOperations(opertains);
        System.out.println(res);
    }

    private static int finalValueAfterOperations(String[] operations) {
        int x =0;
        for(String ops:operations){
            if(ops.equals("X--")|| ops.equals("--X"))
                x -=1;
            else
                x +=1;
        }
        return x;
    }
}
