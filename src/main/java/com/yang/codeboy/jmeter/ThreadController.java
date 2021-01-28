package com.yang.codeboy.jmeter;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-19
 */
@RestController
@RequestMapping("/thread")
@Slf4j
public class ThreadController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/one")
    public void insert1() throws Exception{
        long start = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        try {
            final CountDownLatch latch = new CountDownLatch(100);
            for (int i = 0; i < 100; i++) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        Order order = Order.builder().id(IdWorker.getId()).number(RandomUtil.randomInt()).name(RandomUtil.randomString(2)).build();
                        orderService.insert(order);
                    }
                };
                threadPool.execute(runnable);
                latch.countDown();
            }
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        log.info("共耗时为：{}",end-start);
    }

    @GetMapping("/two")
    public void insert2() throws Exception{
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Order order = Order.builder().id(IdWorker.getId()).number(RandomUtil.randomInt()).name(RandomUtil.randomString(2)).build();
            orderService.insert(order);
        }
        long end = System.currentTimeMillis();
        log.info("共耗时为：{}",end-start);
    }
}
