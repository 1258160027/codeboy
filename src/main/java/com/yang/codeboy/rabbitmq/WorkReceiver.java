package com.yang.codeboy.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-15
 */
@Slf4j
@RabbitListener(queues = "work.hello")
public class WorkReceiver {

    private final int instance;

    public WorkReceiver(int i){
        this.instance = i;
    }

    @RabbitHandler
    public void receive(String in){
        StopWatch watch = new StopWatch();
        watch.start();
        log.info("instance {} [x] Received '{}'",this.instance,in);
        doWork(in);
        watch.stop();
        log.info("instance {} [x] Done in {}s",this.instance,watch.getTotalTimeSeconds());
    }

    private void doWork(String in) {
        for (char ch:in.toCharArray()){
            if (ch == '.'){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
