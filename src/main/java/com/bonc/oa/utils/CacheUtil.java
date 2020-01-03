package com.bonc.oa.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheUtil {

    public static String lic = "";
    public static  Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

    public static Map<String, Object> getCache() {
        return cache;
    }

}
