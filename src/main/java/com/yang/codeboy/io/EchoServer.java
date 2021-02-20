package com.yang.codeboy.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-01
 */
public class EchoServer {
    static class EchoServerReactor implements Runnable {
        Selector selector;
        ServerSocketChannel serverSocketChannel;

        EchoServerReactor() throws IOException {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8082));
            SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            sk.attach(new AcceptorHandler());
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    while (selector.select() > 0) {
                        Set<SelectionKey> keys = selector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = keys.iterator();
                        while (keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();
                            dispatch(key);
                        }
                        keys.clear();
                    }
                    //selector.select();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void dispatch(SelectionKey key) {
            Runnable handler = (Runnable) key.attachment();
            if (null != handler) {
                handler.run();
            }
        }

        class AcceptorHandler implements Runnable {
            @Override
            public void run() {
                try {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (null != socketChannel) {
                        new EchoHandler(selector, socketChannel);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new EchoServerReactor()).start();
    }
}
