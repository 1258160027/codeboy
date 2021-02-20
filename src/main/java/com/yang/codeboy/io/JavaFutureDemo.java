package com.yang.codeboy.io;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-02
 */
@Slf4j
public class JavaFutureDemo {
    public static final int SLEEP_GPA = 500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static class HotWarterJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗好水壶");
                log.info("灌上凉水");
                log.info("放在火上");
                Thread.sleep(SLEEP_GPA);
                log.info("水开了");
            } catch (Exception e) {
                log.info("发生异常被中断");
                return false;
            }
            log.info("烧水运行结束");
            return true;
        }
    }

    static class WashJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            try {
                log.info("洗茶壶");
                log.info("洗茶杯");
                log.info("拿茶叶");
                Thread.sleep(SLEEP_GPA);
                log.info("洗完了");
            } catch (Exception e) {
                log.info("清洗工作发生异常被中断");
                return false;
            }
            log.info("清洗工作运行结束");
            return true;
        }
    }

    public static void drinkTea(boolean warterOk, boolean cupOk) {
        if (warterOk && cupOk) {
            log.info("泡茶喝");
        } else if (!warterOk) {
            log.info("烧水失败，没有茶喝了");
        } else if (!cupOk) {
            log.info("杯子洗不了，没有茶喝了");
        }
    }

    public static void main(String[] args) {
        Callable<Boolean> hJob = new HotWarterJob();
        FutureTask<Boolean> hTask = new FutureTask<>(hJob);
        Callable<Boolean> wJob = new WashJob();
        FutureTask<Boolean> wTask = new FutureTask<>(wJob);
        new Thread(hTask, "烧水线程").start();
        new Thread(wTask, "清洗线程").start();
        Thread.currentThread().setName("主线程");
        try {
            Boolean warterOk = hTask.get();
            Boolean washOk = wTask.get();
            drinkTea(warterOk, washOk);
        } catch (InterruptedException e) {
            log.info(getCurThreadName() + "发生中断异常");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        log.info(getCurThreadName() + "运行结束");
    }
}
