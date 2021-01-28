package com.yang.codeboy.io;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-27
 */
public class NIOReadTest {
    public static void main(String[] args) {
        String fileName = "D:/JavaFile/nio.txt";
        try (FileInputStream in = new FileInputStream(new File(fileName));
             FileChannel channel = in.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len = -1;
            while ((len = channel.read(buffer)) != -1) {
                buffer.clear();
                byte[] bytes = buffer.array();
                System.out.write(bytes, 0, len);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
