package com.yang.codeboy.config;


import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-22
 */
@Slf4j
public class mySender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String exchangeName = "lan";

    public void send(){
        String message = "成功发送一份邮件~~";
        MailAccount account = new MailAccount();
        account.setHost("smtp.qq.com");
        account.setPort(587);
        account.setAuth(true);
        account.setFrom("1258160027@qq.com");
        account.setUser("1258160027");
        account.setPass("lmqnrlxvmfqlbaei");
        MailUtil.send(account,"rti_78bzr25zp@dingtalk.com","测试", "邮件来自codeboy",false);
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }

    public void send2(){
        for (int i = 0; i < 100; i++) {
            Order order = Order.builder().id(IdWorker.getId()).number(RandomUtil.randomInt(100)).name(RandomUtil.randomString(2)).build();
            rabbitTemplate.convertAndSend(exchangeName,"",order);
        }
    }

}
