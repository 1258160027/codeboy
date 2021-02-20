package com.yang.codeboy.io;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-05
 */
@Slf4j
public class WriteReadTest {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(9, 100);
        log.info("动作：分配ByteBuf（9,100）");
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        log.info("动作：写入4个字节（1,2,3,4）");
        log.info("start============:get===========");
        getByteBuf(buffer);
        log.info("动作：取数据ByteBuf");
        log.info("start============:read===========");
        readByteBuf(buffer);
        log.info("动作：读完ByteBuf");
    }

    private static void getByteBuf(ByteBuf buffer) {
        for (int i = 0; i < buffer.readableBytes(); i++) {
            log.info("读一个字节：" + buffer.getByte(i));
        }
    }

    private static void readByteBuf(ByteBuf buffer) {
        while (buffer.isReadable()) {
            log.info("取一个字节：" + buffer.readByte());
        }
    }
}
