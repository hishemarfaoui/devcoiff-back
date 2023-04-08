package com.example.devcoiff.Services;

import com.example.devcoiff.Payloads.Mail.Mail;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

@Service
@Transactional
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendMail(Mail mail) throws MailException, MessagingException {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(mail.getMailAddress());
        simpleMailMessage.setSubject(mail.getMailSubject());
        simpleMailMessage.setText(mail.getMailMessage());
        javaMailSender.send(simpleMailMessage);
    }

}