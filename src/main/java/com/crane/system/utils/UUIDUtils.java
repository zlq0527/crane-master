package com.crane.system.utils;

import java.util.UUID;


public class UUIDUtils {
    public static String replaceUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
