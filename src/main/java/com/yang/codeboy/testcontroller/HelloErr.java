package com.yang.codeboy.testcontroller;

import com.yang.codeboy.annotation.CatchErr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-04
 */
@RestController
@CatchErr
public class HelloErr {

    @Autowired
    private SayHelloService sayHelloService;
    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("/err")
    public String err(){
        int a=1/0;
        return "执行异常注解";
    }

    @GetMapping("/task")
    public void getInfo() throws Exception{
        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();

        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();

        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
        System.out.println(times);
    }

    @GetMapping("getMsg")
    public void msg(){
        sayHelloService.sync();
    }

}
