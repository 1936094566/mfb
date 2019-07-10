package com.mc.mfb.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/30
 * @Time:17:01
 **/
@Component
@Data
public class MailConfig {
    /**
     * 发件邮箱
     */
    @Value("${spring.mail.username}")
    private String emailFrom;
}
