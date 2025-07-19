package com.july;

import com.februry.MinimumOperationsToExceedThresholdValueII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersfromtheFilesystem {
    public static void main(String[] args) {
        String [] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> res = removeSubfolders(folder);
        System.out.println(res);
    }

    private static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        for(String s : folder){
            if(res.isEmpty()|| !s.startsWith(res.get(res.size()-1)+"/")){
                res.add(s);
            }
        }
        return res;
    }
}
