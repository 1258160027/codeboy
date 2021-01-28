package com.yang.codeboy.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-22
 */
@Configuration
public class RabbitConfig {

    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange("lan");
    }

    @Bean
    public Queue queue1(){
        return new AnonymousQueue();
    }

    @Bean
    public Queue queue2(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1(FanoutExchange exchange, Queue queue1){
        return BindingBuilder.bind(queue1).to(exchange);
    }

    @Bean
    public Binding binding2(FanoutExchange exchange, Queue queue2){
        return BindingBuilder.bind(queue2).to(exchange);
    }

    @Bean
    public mySender mySender(){
        return new mySender();
    }

    @Bean
    public myReceiver myReceiver(){
        return new myReceiver();
    }


}
