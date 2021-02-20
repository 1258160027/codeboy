package com.yang.codeboy.io.json;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-08
 */
@Slf4j
public class JsonSendClient {
    private static String content = "努力不要想太多！";
    private final int port;
    private String ip;
    Bootstrap b = new Bootstrap();

    public JsonSendClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void runClient() {
        EventLoopGroup work = new NioEventLoopGroup();
        try {
            b.group(work);
            b.remoteAddress(ip, port);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LengthFieldPrepender(4));
                    ch.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                }
            });
            ChannelFuture f = b.connect();
            f.addListener((ChannelFuture listener) -> {
                if (listener.isSuccess()) {
                    log.info("Client 客户端连接成功！");
                } else {
                    log.info("Client 客户端连接失败！");
                }
            });
            f.sync();
            Channel channel = f.channel();
            for (int i = 0; i < 1000; i++) {
                JsonMsg user = build(i, i + "->" + content);
                channel.writeAndFlush(user.convertToJson());
                log.info("发送报文：{}", user.convertToJson());
            }
            channel.flush();
            ChannelFuture closeFuture = channel.closeFuture();
            closeFuture.sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            work.shutdownGracefully();
        }
    }

    public JsonMsg build(int id, String content) {
        JsonMsg user = new JsonMsg();
        user.setId(id);
        user.setContent(content);
        return user;
    }

    public static void main(String[] args) {
        new JsonSendClient("127.0.0.1", 8082).runClient();
    }
}
