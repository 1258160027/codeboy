package com.yang.codeboy.sendmessage;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2020-11-11
 */
@ConfigurationProperties(prefix = "sms")
@Data
public class SmsProperties {

    private String name;
    private String msg;

}
