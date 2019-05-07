package com.mc.mfb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 * EnableJpaRepositories: jpa扫描注解
 */
@SpringBootApplication
@EnableJpaRepositories("com.mc.mfb.admin.dao")
public class MfbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MfbApplication.class, args);
    }

}
