package com.ratnikov.HW.HW2;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

public class MyMessageImpl implements MyMessage{
    String recipients;

    public MyMessageImpl(String recipients) {
        this.recipients = recipients;
    }

    @Override
    public MimeMessage salaryReport(StringBuilder resultingHtml) throws Exception {
        MimeMessage message = new JavaMailSenderImpl().createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipients);
        // setting message text, last parameter 'true' says that it is HTML format
        helper.setText(resultingHtml.toString(), true);
        helper.setSubject("Monthly department salary report");

        return message;
    }
}
