package es.kiwi.service.impl;

import es.kiwi.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl implements SendMailService {
    
    @Autowired
    private JavaMailSender javaMailSender;

    //发送人
    private String from = "";

    //接收人
    private String to = "";

    //标题
    private String subject = "测试邮件";

    //正文
    private String context = "<a href = 'https://www.google.com'>点击</a>";
    
    @Override
    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); //附件
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(context, true);// html

            //添加附件
            File f1 = new File("");
            helper.addAttachment(f1.getName(), f1);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
