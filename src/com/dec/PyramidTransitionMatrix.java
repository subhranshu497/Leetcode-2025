package com.dec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {
    private static Map<String, Boolean> t = new HashMap<>();
    public static void main(String[] args) {
        List<String> allowed = List.of("BCC","CDE","CEA","FFF");
        String bottom = "BCD";
        boolean flag = pyramidTransition(allowed, bottom);
        System.out.println(flag);
    }

    private static boolean pyramidTransition(List<String> allowed, String bottom) {
        Map<String, List<Character>> map = new HashMap<>();
        for(String s:allowed){
            String sub = s.substring(0,2);
            map.computeIfAbsent(sub, k-> new ArrayList<>()).add(s.charAt(2));
        }
        return pyramidTransitionHelper(bottom, map, 0,new StringBuilder());
    }

    private static boolean pyramidTransitionHelper(String curr, Map<String, List<Character>> map, int i, StringBuilder above) {
        if(curr.length()==1) return true;
        String key = curr + "_" + i + "_" + above.toString();
        if (t.containsKey(key)) {
            return t.get(key);
        }
        if(i==curr.length()-1){
            boolean res = pyramidTransitionHelper(String.valueOf(above),map,0,new StringBuilder());
            t.put(key, res);
            return res;
        }
        String pair = curr.substring(i,i+2);
        if(!map.containsKey(pair)){
            t.put(key, false);
            return false;
        }
        for(char ch:map.get(pair)){
            above.append(ch);
            if(pyramidTransitionHelper(curr,map,i+1, above))
            {
                t.put(key, true);
                return true;
            }
            above.deleteCharAt(above.length()-1);
        }
        t.put(key, false);
        return false;
    }
}
