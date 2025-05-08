package com.may;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    private Map<String, Integer> logStream;

    public LoggerRateLimiter() {
        logStream = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!logStream.containsKey(message)){
            logStream.put(message, timestamp);
            return true;
        }
        else{
            int currentTimeStamp = logStream.get(message);
            if(timestamp-currentTimeStamp >=10){
                logStream.put(message, timestamp);
                return true;
            }else return false;
        }
    }
}
