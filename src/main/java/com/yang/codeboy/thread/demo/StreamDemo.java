package com.yang.codeboy.thread.demo;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-26
 */
public class StreamDemo {
    /**
     * main: 1 + 2 = 3
     * main: 3 + 3 = 6
     * main: 6 + 4 = 10
     * main: 10 + 5 = 15
     * main: 15 + 6 = 21
     * main: 21 + 7 = 28
     * main: 28 + 8 = 36
     * main: 36 + 9 = 45
     * 45
     * 耗时：50
     */
    public static void main(String[] args) {
        long n = System.currentTimeMillis();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallel()
                .reduce((a, b) -> {
                    System.out.println(String.format("%s: %d + %d = %d",
                            Thread.currentThread().getName(), a, b, a + b));
                    return a + b;
                }).ifPresent(System.out::println);
        long m = System.currentTimeMillis();
        System.out.println("耗时：" + (m - n));
    }
}
