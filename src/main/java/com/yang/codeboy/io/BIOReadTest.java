package com.yang.codeboy.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-27
 */
public class BIOReadTest {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("D:/JavaFile/file.txt")) {
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = in.read(buff)) != -1) {
                System.out.println(new String(buff, 0 ,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
