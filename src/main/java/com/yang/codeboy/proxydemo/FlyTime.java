package com.yang.codeboy.proxydemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-10-28
 */
public class FlyTime implements Flyable{
    private Flyable flyable;

    public FlyTime(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        long start = System.currentTimeMillis();
        flyable.fly();
        long end = System.currentTimeMillis();
        System.out.println("Fly time ="+(end-start));
    }
}
