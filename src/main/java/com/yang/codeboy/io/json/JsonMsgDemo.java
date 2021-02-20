package com.yang.codeboy.io.json;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-08
 */
@Slf4j
public class JsonMsgDemo {
    public static JsonMsg buildMsg() {
        JsonMsg user = new JsonMsg();
        user.setId(1000);
        user.setContent("技术改变生活，而我只想发财~");
        return user;
    }

    public static void main(String[] args) {
        try {
            JsonMsg message = buildMsg();
            String json = message.convertToJson();
            log.info("json:={}", json);
            JsonMsg jsonMsg = JsonMsg.parseFromJson(json);
            log.info("id:={}", jsonMsg.getId());
            log.info("content:={}", jsonMsg.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
