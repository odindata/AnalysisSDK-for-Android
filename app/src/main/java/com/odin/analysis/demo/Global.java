package com.odin.analysis.demo;

public class Global {

    private static String userId;

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        Global.userId = userId;
    }
}
