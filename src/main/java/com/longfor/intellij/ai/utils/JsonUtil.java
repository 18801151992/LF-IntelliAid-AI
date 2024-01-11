package com.longfor.intellij.ai.utils;

import com.google.gson.Gson;

/**
 * @Author deven
 * @Date 2024-01-11 14:43
 */
public class JsonUtil {

    // 创建一个静态的 Gson 实例
    private static final Gson gson = new Gson();

    // 静态方法，使用静态 Gson 实例
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

}
