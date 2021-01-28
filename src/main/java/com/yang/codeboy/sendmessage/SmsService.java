package com.yang.codeboy.sendmessage;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
@Data
public class SmsService {
    private String name;
    private String msg;

    public void send(){
        System.out.println(name+" 说："+msg);
    }
}
