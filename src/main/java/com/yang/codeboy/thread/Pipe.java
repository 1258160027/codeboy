package com.yang.codeboy.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-23
 */
public class Pipe {
    static class PipeRead implements Runnable {

        PipedReader pipedReader;

        public PipeRead(PipedReader reader) {
            this.pipedReader = reader;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            while (true) {
                try {
                    if (((receive = pipedReader.read()) != -1)) {
                        System.out.print((char) receive);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PipeWrite implements Runnable {

        PipedWriter pipedWriter;

        public PipeWrite(PipedWriter writer) {
            this.pipedWriter = writer;
        }

        @Override
        public void run() {
            System.out.println("this is writer");
            int receive = 0;
            try {
                pipedWriter.write("test");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    pipedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);
        new Thread(new PipeRead(reader)).start();
        Thread.sleep(1000);
        Thread a = new Thread();
        a.join();
        new Thread(new PipeWrite(writer)).start();
    }
}
