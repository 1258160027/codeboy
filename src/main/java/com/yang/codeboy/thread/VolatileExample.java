package com.yang.codeboy.thread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-24
 */
public class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("这是写方法~~");
        a = 1;
        flag = true;
    }

    public void reader() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("这是读方法~~");
        if (flag) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();
        new Thread(() -> {
            try {
                example.writer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                example.reader();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
