package com.yang.codeboy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-22
 */
@Slf4j
public class myReceiver {

    @Autowired
    private Order1Service order1Service;
    /*
    @RabbitListener(queues = "#{queue1.name}")
    public void receive1(String msg) {
        receive(msg, 1);
    }

    @RabbitListener(queues = "#{queue2.name}")
    public void receive2(String msg) {
        receive(msg, 2);
    }

    private void receive(String msg, int i) {
        log.info("{}接收到一条消息：{}", i, msg);
    }
     */

    @RabbitListener(queues = "#{queue1.name}")
    public void receive1(Order order) {
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        final CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    receive(order, 1);
                }
            });
            latch.countDown();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @RabbitListener(queues = "#{queue2.name}")
//    public void receive2(Order order) {
//        receive(order, 2);
//    }

    private void receive(Order order, int i) {
        order1Service.insert(order);
        log.info("{}接收到一条消息：{}", i, order);
    }


}
