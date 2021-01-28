package com.yang.codeboy.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-15
 */

public class SimpleSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String queueName = "simple.hello";

    public void send(){
        String message = "Hello World!";
        this.rabbitTemplate.convertAndSend(queueName,message);
        LOGGER.info(" [x] Send '{}'",message);
    }


}
