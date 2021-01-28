package com.yang.codeboy.proxydemo;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-10-28
 */
public class Bird implements Flyable{
    static{
        System.out.println("I am a little bird!!!");
    }
    @Override
    public void fly() {
        System.out.println("Bird is flying");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
