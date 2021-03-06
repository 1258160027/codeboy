package com.yang.codeboy.io;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-07
 */
@Slf4j
public class NettyDumpSendClient {
    private int severPort;
    private String severIp;
    Bootstrap b = new Bootstrap();

    public NettyDumpSendClient(String ip, int port) {
        this.severIp = ip;
        this.severPort = port;
    }

    public void runClient() {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            b.group(workGroup);
            b.channel(NioSocketChannel.class);
            b.remoteAddress(severIp, severPort);
            b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(NettyEchoClientHandler.INSTANCE);
                }
            });
            ChannelFuture channelFuture = b.connect();
            channelFuture.addListener((ChannelFuture listen) -> {
                if (listen.isSuccess()) {
                    log.info("NettyEchoClient客户端连接成功！");
                } else {
                    log.info("NettyEchoClient客户端连接失败！");
                }
            });
            channelFuture.sync();
            Channel channel = channelFuture.channel();
            String content = "就让我心死在这里吧~~";
            byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < 1000; i++) {
                ByteBuf byteBuf = channel.alloc().buffer();
                byteBuf.writeBytes(bytes);
                channel.writeAndFlush(byteBuf);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new NettyDumpSendClient("127.0.0.1", 8082).runClient();
    }
}
