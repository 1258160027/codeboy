package com.yang.codeboy.io.json;

import com.yang.codeboy.io.util.JsonUtil;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-08
 */
@Data
public class JsonMsg {
    private int id;
    private String content;

    public String convertToJson() {
        return JsonUtil.pojoToJson(this);
    }

    public static JsonMsg parseFromJson(String json) {
        return JsonUtil.jsonToPojo(json, JsonMsg.class);
    }
}
