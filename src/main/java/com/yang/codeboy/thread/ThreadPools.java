package com.yang.codeboy.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-12
 */
public class ThreadPools {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new MyRunThread());
        }
        threadPool.shutdown();
    }
}

class MyRunThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"我起飞了!!!");
    }
}
