package com.mc.mfb.admin.controller;

import com.mc.mfb.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/30
 * @Time:16:57
 * 邮箱控制层
 *
 **/
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailConfig mailConfig;
    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/sendSimple")
    public Object sendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailConfig.getEmailFrom());
        message.setTo("1936094566@qq.com");
        message.setSubject("你好世界!");
        message.setText("hello world!!");
        mailSender.send(message);
        return  "success";
    }
    @RequestMapping("/sendPicture")
    public Object sendPicture() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(mailConfig.getEmailFrom());
        //helper.setTo("1936094566@qq.com");
        //"1686150650@qq.com",
       helper.setTo(new String[]{"1936094566@qq.com","3105388450@qq.com"});

        //helper.setTo("1936094566@qq.com");
        helper.setSubject("再来一次");
        String content = "<html><body><h3><font color=\"red\">" + "不如绑在板凳上,sinsnnsnsnsnsns，扁担宽,板凳长,扁担绑在板凳上" + "</font></h3>"
                + "<img src=\'cid:test\'></body></html>";
        helper.setText(content,true);
        FileSystemResource fsr = new FileSystemResource(new File("E:\\timg.gif"));
        //重复使用添加多个图片
        helper.addInline("test", fsr);
        mailSender.send(mimeMessage);
        return "success";
    }
}
