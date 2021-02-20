package com.yang.codeboy.io;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-07
 */
@Slf4j
public class Byte2IntegerReplayDecoder extends ReplayingDecoder {
    @Override
    public void decode(ChannelHandlerContext cxt, ByteBuf in, List<Object> out) throws Exception {
        int i = in.readInt();
        log.info("解码出一个整数：{}",i);
        out.add(i);
    }
}
