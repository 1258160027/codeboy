package com.yang.codeboy.jdkorcglibproxy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-03
 */
public class ProxyTest {
    public static void main(String[] args) {
        SendMessage sendMessage = (SendMessage) JdkProxyFactory.getProxy(new SendMessageImpl());
        sendMessage.say("张岚大帅哥");
        ISendMessage send = (ISendMessage) CglibProxyFactory.getProxy(ISendMessage.class);
        send.say("杨美丽");
    }
}
