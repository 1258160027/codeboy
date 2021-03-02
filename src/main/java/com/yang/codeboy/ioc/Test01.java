package com.yang.codeboy.ioc;

import com.yang.codeboy.ioc.model.Car;
import org.checkerframework.common.reflection.qual.GetClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-20
 */
public class Test01 {
    public static void main(String[] args) throws Exception{


        Class clazz = Class.forName("com.yang.codeboy.ioc.model.Car");
        Constructor cons = clazz.getDeclaredConstructor();
        Car car = (Car) cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car,"宝马M4");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car,"蓝色");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car,200);

        System.out.println(car.toString());


//        Class<Car> c = Car.class;
//
//        Class<? extends Car> aClass = car.getClass();
//
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        Class<?> aClass1 = loader.loadClass("com.yang.codeboy.ioc.model.Car");

    }
}
