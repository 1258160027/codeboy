package com.yang.codeboy.thread.demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-26
 */
public class FibonacciDemo {

    public static int iterative(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            int first = 1;
            int second = 1;
            int third = 0;
            for (int i = 2; i < n; i++) {
                third = first + second;
                first = second;
                second = third;
            }
            return third;
        }
    }

    public static int recursive(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return recursive(n - 1) + recursive(n - 2);
        }
    }

    static class Fibonacci extends RecursiveTask<Integer> {

        int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n == 1 || n == 2) {
                return 1;
            } else {
                Fibonacci f1 = new Fibonacci(n - 1);
                f1.fork();
                Fibonacci f2 = new Fibonacci(n - 2);
                f2.fork();
                return f1.join() + f2.join();
            }
        }
    }


    /*
    迭代，共耗时：0
    迭代，结果为：102334155

    递归，共耗时：231
    递归，结果为：102334155

    CPU核数：12
    迭代，结果为：102334155
    迭代，共耗时：1865
    */

    public static void main(String[] args) throws Exception{
        /*
        long start = System.currentTimeMillis();
        int result = iterative(40);
        long end = System.currentTimeMillis();
        System.out.println("迭代，共耗时：" + (end - start));
        System.out.println("迭代，结果为：" + result);
         */
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("CPU核数：" + Runtime.getRuntime().availableProcessors());
        long start = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci(40);
        Future<Integer> future = forkJoinPool.submit(fibonacci);
        System.out.println("迭代，结果为：" + future.get());
        long end = System.currentTimeMillis();
        System.out.println("迭代，共耗时：" + (end - start));
    }

}
