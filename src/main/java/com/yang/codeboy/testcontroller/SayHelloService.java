package com.yang.codeboy.testcontroller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-04
 */
@Component
public class SayHelloService {

    @Async
    public void sync(){
        System.out.println("异步线性开始休眠5秒");
        Future<String> helloMessage;
        try {
            Thread.sleep(1000);
            System.out.println("线程名字："+Thread.currentThread().getName());
            helloMessage = new AsyncResult<>("success");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int a=1/0;
        System.out.println("异步线程开始运行");
    }
}
