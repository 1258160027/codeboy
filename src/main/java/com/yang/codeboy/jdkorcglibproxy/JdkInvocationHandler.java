package com.yang.codeboy.jdkorcglibproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-03
 */
public class JdkInvocationHandler implements InvocationHandler {

    private final Object target;

    public JdkInvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method "+method.getName());
        Object result = method.invoke(target, args);
        System.out.println("after method "+method.getName());
        return result;
    }
}
