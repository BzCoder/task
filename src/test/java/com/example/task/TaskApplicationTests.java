package com.example.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    public void setSimpleEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setText("测试邮件内容");
        simpleMailMessage.setSubject("测试邮件标题");
        simpleMailMessage.setFrom("107630221@qq.com");
        simpleMailMessage.setTo("107630221@qq.com","395927613@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void setComplicatedEmail() throws MessagingException {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        //设置可以上传文件
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);

        //设置邮件内容为HTML格式
        mimeMessageHelper.setText("<b style='color=red' 复杂邮件内容>",true);
        mimeMessageHelper.setSubject("复杂邮件标题");
        mimeMessageHelper.setFrom("107630221@qq.com");
        mimeMessageHelper.setTo(new String[]{"107630221@qq.com","395927613@qq.com"});
        //设置上传文件
        mimeMessageHelper.addAttachment("a1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.png"));
        mimeMessageHelper.addAttachment("123.docx",new File("C:\\Users\\Administrator\\Desktop\\CDN调度系统需求.docx"));
        javaMailSender.send(mimeMailMessage);
    }

}
