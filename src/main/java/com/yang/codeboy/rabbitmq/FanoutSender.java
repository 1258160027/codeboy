package com.yang.codeboy.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-15
 */
@Slf4j
public class FanoutSender {
    @Autowired
    private RabbitTemplate template;

    private static final String exchangeName = "exchange.fanout";

    public void send(int index){
        StringBuilder builder = new StringBuilder("Hello");
        int limitIndex = index%3 + 1;
        for (int i = 0; i < limitIndex; i++) {
            builder.append(".");
        }
        builder.append(index+1);
        String message = builder.toString();
        template.convertAndSend(exchangeName,"",message);
        log.info(" [x] Send '{}'",message);
    }



}
