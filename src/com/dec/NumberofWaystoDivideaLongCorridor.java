package com.dec;

import java.util.ArrayList;
import java.util.List;

public class NumberofWaystoDivideaLongCorridor {
    private static int MOD = 1000000007;

    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        int ways = numberOfWaysI(corridor);
        System.out.println(ways);
    }

    private static int numberOfWaysI(String corridor) {
        int n = corridor.length();
        long res = 1;
        List<Integer> indexList = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(corridor.charAt(i)=='S')
                indexList.add(i);
        }
        if(indexList.size()<=1 || indexList.size()%2 !=0) return 0;
        if(indexList.size()==2) return 1;
        for(int i=2;i<indexList.size();i+=2){
            res = (res*(indexList.get(i)-indexList.get(i-1)))%MOD;
        }
        return (int)res;
    }


}
