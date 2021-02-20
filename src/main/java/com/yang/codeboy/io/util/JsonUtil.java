package com.yang.codeboy.io.util;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-08
 */
public class JsonUtil {
    static GsonBuilder gb = new GsonBuilder();

    static {
        gb.disableHtmlEscaping();
    }

    public static String pojoToJson(Object obj) {
        String json = gb.create().toJson(obj);
        return json;
    }

    public static <T> T jsonToPojo(String json, Class<T> tClass) {
        T t = JSONObject.parseObject(json, tClass);
        return t;
    }
}
