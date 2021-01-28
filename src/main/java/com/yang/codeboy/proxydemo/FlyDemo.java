package com.yang.codeboy.proxydemo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-10-28
 */
public class FlyDemo {

    public static void main(String[] args) {
        Bird bird = new Bird();
        FlyTime fly = new FlyTime(new FlyLog(bird));
//        FlyLog fly = new FlyLog(new FlyTime(bird));
        fly.fly();
    }
}
