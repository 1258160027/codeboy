package com.yang.codeboy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-29
 */
public class CopyFileTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        File source = new File("D:/JavaFile/file.txt");
        File target = new File("D:/JavaFile/nio.txt");
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(target);
             FileChannel inChannel = in.getChannel();
             FileChannel outChannel = out.getChannel()) {
            int read = -1;
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while ((read = inChannel.read(buffer)) != -1) {
                buffer.flip();
                int write = 0;
                while ((write = outChannel.write(buffer)) != 0) {
                    System.out.println("写入字节：" + write);
                }
                buffer.clear();
            }
            outChannel.force(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start));
    }
}
