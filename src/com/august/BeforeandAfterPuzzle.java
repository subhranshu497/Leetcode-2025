package com.august;

import java.util.*;

public class BeforeandAfterPuzzle {
    public static void main(String[] args) {
        String [] phrases = {"mission statement",
                "a quick bite to eat",
                "a chip off the old block",
                "chocolate bar",
                "mission impossible",
                "a man on a mission",
                "block party",
                "eat my words",
                "bar of soap"};
        List<String> ans = beforeAndAfterPuzzles(phrases);
        System.out.println(ans);
    }

    private static List<String> beforeAndAfterPuzzles(String[] phrases) {
        TreeSet<String> tSet=new TreeSet<String>();
        List<String> res=new ArrayList<String>();
        for(int i=0;i<phrases.length;i++)
        {
            String str1[]=phrases[i].split(" ");
            int first = phrases[i].length()-str1[str1.length-1].length();
            String p=phrases[i].substring(0,first);
            for(int j=0;j<phrases.length;j++)
            {
                if(i!=j)
                {
                    String str2[]=phrases[j].split(" ");
                    if(str1[str1.length-1].equals(str2[0]))
                    {
                        tSet.add(p+phrases[j]);
                    }
                }
            }
        }
        Iterator<String> itr=tSet.iterator();
        while(itr.hasNext())
        {
            res.add(itr.next());
        }
        return res;
    }
}
