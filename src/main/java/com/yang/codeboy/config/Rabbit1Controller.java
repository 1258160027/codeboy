package com.yang.codeboy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-22
 */
@RestController
@RequestMapping("/mq")
public class Rabbit1Controller {

    @Autowired
    private mySender sender;

    @GetMapping
    public void send(){
        sender.send();
    }

    @GetMapping("/test")
    public void send2(){
        sender.send2();
    }

}
