package com.yang.codeboy.mylock;

import sun.applet.Main;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
public class Test {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
    }
}
