package org.example.util;

import java.sql.Timestamp;

public class Util {

    public static Timestamp currentTimeStamp(){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Current Timestamp: " + currentTimestamp.getTime() + " milliseconds");
        System.out.println("Formatted Timestamp: " + currentTimestamp.toString());
        return currentTimestamp;
    }
}
