package com.yang.codeboy.io;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-07
 */
@Slf4j
public class String2IntegerEncoder extends MessageToMessageEncoder<String> {
    @Override
    protected void encode(ChannelHandlerContext ctx, String s, List<Object> list) throws Exception {
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c >= 48 && c <= 57) {
                list.add(new Integer(c));
            }
        }
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
