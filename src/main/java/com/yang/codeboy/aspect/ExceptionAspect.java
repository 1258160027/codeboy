package com.yang.codeboy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-04
 */
@Aspect
@Component
public class ExceptionAspect {

    @Pointcut("@annotation(com.yang.codeboy.annotation.CatchErr)")
    private void err(){
    }

    @Around("err()")
    public void after(ProceedingJoinPoint point){
        try {
            point.proceed();
        }catch (Throwable e){
            System.out.println(e);
        }
        System.out.println("执行前捕获异常");
    }

}
