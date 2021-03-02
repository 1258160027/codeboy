package com.yang.codeboy.thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-26
 */
public class StreamParallelDemo {
    public static void main(String[] args) {
        System.out.println("本计算机核数：" + Runtime.getRuntime().availableProcessors());
        List<Integer> list = new ArrayList<>(1000000);
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            list.add(random.nextInt(100));
        }
        long prevTime = System.currentTimeMillis();
        list.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println("单线程计算耗时：" + (getCurrentTime() - prevTime));

        prevTime = System.currentTimeMillis();
        list.stream().parallel().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println("多线程计算耗时：" + (getCurrentTime() - prevTime));
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
