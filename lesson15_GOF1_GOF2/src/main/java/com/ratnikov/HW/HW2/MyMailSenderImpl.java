package com.ratnikov.HW.HW2;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.internet.MimeMessage;

public class MyMailSenderImpl implements MyMailSender{
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    @Override
    public void sendMailSender(MimeMessage message) {
        mailSender.setHost("mail.google.com");
        mailSender.send(message);
    }
}
