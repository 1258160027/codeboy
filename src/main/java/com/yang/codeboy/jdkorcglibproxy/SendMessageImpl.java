package com.yang.codeboy.jdkorcglibproxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-03
 */
public class SendMessageImpl implements SendMessage{
    @Override
    public String say(String message) {
        System.out.println("send message:"+message);
        return message;
    }
}
