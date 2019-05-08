package com.mc.mfb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * EnableJpaRepositories: jpa扫描注解
 */
@SpringBootApplication
@MapperScan("com.mc.mfb.admin.dao")
public class MfbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MfbApplication.class, args);
    }

}
