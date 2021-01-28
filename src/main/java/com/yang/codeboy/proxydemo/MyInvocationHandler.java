package com.yang.codeboy.proxydemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-10-28
 */
public class MyInvocationHandler implements InvocationHandler {

    private Bird bird;

    public MyInvocationHandler(Bird bird){
        this.bird = bird;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  {
        long start = System.currentTimeMillis();
        try {
            method.invoke(bird,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Fly time = "+(end - start));
        return proxy;
    }

}
