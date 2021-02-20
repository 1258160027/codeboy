package com.yang.codeboy.io;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-07
 */
@Slf4j
@ChannelHandler.Sharable
public class NettyEchoServerHandler extends ChannelInboundHandlerAdapter {
    public static final NettyEchoServerHandler INSTANCE = new NettyEchoServerHandler();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        log.info("msg type：{}", (in.hasArray() ? "堆内存" : "直接内存"));
        int len = in.readableBytes();
        byte[] arr = new byte[len];
        in.getBytes(0, arr);
        log.info("server received:{}", new String(arr, StandardCharsets.UTF_8));
        log.info("写回前, msg.refCnt:{}", ((ByteBuf) msg).refCnt());
        ChannelFuture channelFuture = ctx.writeAndFlush(msg);
        channelFuture.addListener((ChannelFutureListener) -> {
            log.info("写回后，msg.refCnt：{}", ((ByteBuf) msg).refCnt());
        });
    }
}
