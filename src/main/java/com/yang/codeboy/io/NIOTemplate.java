package com.yang.codeboy.io;

import java.nio.IntBuffer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-29
 */
public class NIOTemplate {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(20);
        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);
        }
        intBuffer.flip();
        intBuffer.rewind();
        System.out.println("-------------------------");
        System.out.println("position=" + intBuffer.position());
        System.out.println("limit=" + intBuffer.limit());
        System.out.println("capacity=" + intBuffer.capacity());
    }
}
