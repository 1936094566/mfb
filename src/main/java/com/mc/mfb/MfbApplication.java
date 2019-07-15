package com.mc.mfb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.mc.mfb.admin.dao")
public class MfbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MfbApplication.class, args);
    }

}
