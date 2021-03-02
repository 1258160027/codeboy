package com.yang.codeboy.thread.lock;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-25
 */
public class SemaphoreDemo {
    static class MyThread implements Runnable {
        private int value;
        private Semaphore semaphore;

        public MyThread(int value, Semaphore semaphore) {
            this.value = value;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(String.format("当前线程是%d，还剩%d个资源，还有%d线程在等待~",
                        value, semaphore.availablePermits(), semaphore.getQueueLength()));
                Thread.sleep(new Random().nextInt(1000));
                semaphore.release();
                System.out.println(String.format("线程%d释放了资源", value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(i, semaphore)).start();
        }
    }
}
