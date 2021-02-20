package com.yang.codeboy.jvm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-20
 */
public class GCTest02 {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
