package com.yang.codeboy.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-12
 */
public class CableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        new Thread(task).start();
        Integer integer = task.get();
        System.out.println(integer);
    }


}
class MyThread implements Callable{
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(100);
    }
}
