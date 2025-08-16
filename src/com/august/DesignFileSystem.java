package com.august;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    Map<String, Integer> map ;
    public DesignFileSystem() {
        map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if(path=="" || path=="/" || map.containsKey(path))return false;
        //create a patharray
        String [] pathArr = path.split("/");
        String tempPath = "/";
        if(pathArr.length>2){
            for(int i=1;i< pathArr.length-1;i++){
                //construct the path and keep on checking
                tempPath +=pathArr[i];
                if(!map.containsKey(tempPath)) return false;
                tempPath +="/";
            }
            map.put(path, value);
            return true;
        }
        else{
            map.put(path, value);
            return true;
        }
    }

    public int get(String path) {
        if(map.containsKey(path)) return map.get(path);
        return -1;
    }
}
