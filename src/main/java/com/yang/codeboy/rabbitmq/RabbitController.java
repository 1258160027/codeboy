package com.yang.codeboy.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-12-15
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private SimpleSender simpleSender;

    @Autowired
    private WorkSender workSender;

    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private TopicSender topicSender;


    @GetMapping("/simple")
    public void simpleTest(){
        for (int i = 0; i < 10; i++) {
            try {
                simpleSender.send();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/work")
    public void workTest(){
        for (int i = 0; i < 10; i++) {
            try {
                workSender.send(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/fanout")
    public void fanoutTest(){
        for(int i=0;i<10;i++){
            try {
                fanoutSender.send(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/topic")
    public void topicTest(){
        for(int i=0;i<10;i++){
            try {
                topicSender.send(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
