package com.yang.codeboy.socketdemo;

import com.yangzkj.mystarter.HelloService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-03
 */
@Slf4j
public class HelloServer {
    public void start(int port){
       try(ServerSocket serverSocket = new ServerSocket(port)){
           Socket socket;
           while ((socket = serverSocket.accept()) != null) {
               log.info("client connected");
               try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
                    Message message = (Message) objectInputStream.readObject();
                    log.info("sever receive message:"+message.getContent());
                    message.setContent("new content");
                    objectOutputStream.writeObject(message);
                    objectOutputStream.flush();
               } catch (IOException | ClassNotFoundException e) {
                   log.error("occur IOException", e);
               }
           }
       }catch (IOException e){
           log.error("occur IOException",e);
       }
    }

    public static void main(String[] args) {
        HelloServer helloServer = new HelloServer();
        helloServer.start(6666);
    }
}
