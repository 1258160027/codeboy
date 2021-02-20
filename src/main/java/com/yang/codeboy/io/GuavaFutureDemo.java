package com.yang.codeboy.io;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-02
 */
@Slf4j
public class GuavaFutureDemo {
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

    static class MainJob implements Runnable {
        Boolean warterOk = false;
        Boolean cupOk = false;
        int gap = SLEEP_GPA / 10;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(gap);
                    log.info("读书中......");
                } catch (InterruptedException e) {
                    log.info(getCurThreadName() + "发生中断异常");
                }
                if (warterOk && cupOk) {
                    drinkTea(warterOk, cupOk);
                }
            }
        }

        public void drinkTea(Boolean warterOk, Boolean cupOk) {
            if (warterOk && cupOk) {
                log.info("泡茶喝");
            } else if (!warterOk) {
                log.info("烧水失败，没有茶喝了");
            } else if (!cupOk) {
                log.info("杯子洗不了，没有茶喝了");
            }
        }
    }

    public static void main(String[] args) {
        MainJob mainJob = new MainJob();
        new Thread(mainJob, "主线程").start();
        Callable<Boolean> hJob = new HotWarterJob();
        Callable<Boolean> wJob = new WashJob();
        ExecutorService jPool = Executors.newFixedThreadPool(10);
        ListeningExecutorService gPool = MoreExecutors.listeningDecorator(jPool);
        ListenableFuture<Boolean> hotFuture = gPool.submit(hJob);
        Futures.addCallback(hotFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean r) {
                if (r) {
                    mainJob.warterOk = true;
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                log.info("烧水失败，没有茶喝了");
            }
        }, gPool);
        ListenableFuture<Boolean> washFuture = gPool.submit(wJob);
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(@Nullable Boolean r) {
                if (r) {
                    mainJob.cupOk = true;
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                log.info("杯子洗不了，没有茶喝了");
            }
        }, gPool);
    }
}
