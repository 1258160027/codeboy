package com.yang.codeboy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-01-07
 */
@Component
@Slf4j
public class TaskDemo1 {

    @Autowired
    private mySender sender;

    // @Scheduled(cron = "0 22 16 * * ?")
    public void send(){
        log.info("我正在执行~~");
        sender.send();
    }

}
