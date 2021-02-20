package com.yang.codeboy.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-01
 */
public class EchoClient {
    public static void startClient() throws Exception {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8082);
        SocketChannel socketChannel = SocketChannel.open(address);
        socketChannel.configureBlocking(false);
        while (!socketChannel.finishConnect()) {
            //
        }
        System.out.println("客户端连接成功~~");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("山河无恙".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        socketChannel.shutdownOutput();
        socketChannel.close();
    }

    public static void main(String[] args) {
        try {
            startClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
