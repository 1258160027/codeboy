package com.yang.codeboy;

import com.yang.codeboy.annotation.EnableSms;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan(value = "com.yang.codeboy")
@EnableSms
//@EnableCaching
public class CodeboyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeboyApplication.class, args);
    }

}
