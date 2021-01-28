package com.yang.codeboy.proxydemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-10-28
 */
public class FlyLog implements Flyable{
    private Flyable flyable;

    public FlyLog(Flyable flyable){
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        System.out.println("Bird fly start...");
        flyable.fly();
        System.out.println("Bird fly end...");
    }
}
