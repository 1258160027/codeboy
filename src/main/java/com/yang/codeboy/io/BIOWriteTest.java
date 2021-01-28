package com.yang.codeboy.io;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-27
 */
public class BIOWriteTest {
    public static void main(String[] args) {
        try(FileOutputStream os = new FileOutputStream("D:/JavaFile/file.txt")) {
            String s = "这是测试一下~~";
            os.write(s.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
