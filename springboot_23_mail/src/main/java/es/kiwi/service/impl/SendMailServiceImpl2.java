package es.kiwi.service.impl;

import es.kiwi.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//@Service
public class SendMailServiceImpl2 implements SendMailService {
    
    @Autowired
    private JavaMailSender javaMailSender;

    //发送人
    private String from = "";

    //接收人
    private String to = "";

    //标题
    private String subject = "测试邮件";

    //正文
    private String context = "测试邮件正文内容";
    
    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);

//        message.setSentDate();
        javaMailSender.send(message);
    }
}
