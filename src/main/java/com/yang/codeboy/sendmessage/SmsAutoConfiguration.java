package com.yang.codeboy.sendmessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
@EnableConfigurationProperties(SmsProperties.class)
@Configuration
@ConditionalOnClass(SmsService.class)
@ConditionalOnProperty(prefix = "sms",value = "enable",matchIfMissing = true)
public class SmsAutoConfiguration {

    @Autowired
    private SmsProperties smsProperties;

    @Bean
    @ConditionalOnMissingBean(SmsService.class)
    void send(){
        SmsService smsService = new SmsService();
        smsService.setName(smsProperties.getName());
        smsService.setMsg(smsProperties.getMsg());
        smsService.send();
    }


}
