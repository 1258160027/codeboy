package com.yang.codeboy.io;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-27
 */
public class NIOWriteTest {
    public static void main(String[] args) {
        String fileName = "D:/JavaFile/nio.txt";
        try (FileOutputStream os = new FileOutputStream(new File(fileName));
             FileChannel channel = os.getChannel()) {
            ByteBuffer encode = StandardCharsets.UTF_8.encode("那个女孩子她根本不爱你~~");
            int length = 0;
            while ((length = channel.write(encode)) != 0) {
                System.out.println("写入长度：" + length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
