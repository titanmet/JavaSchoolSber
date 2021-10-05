package com.ratnikov.HW.HW2;

import javax.mail.internet.MimeMessage;

public interface MyMessage {
    MimeMessage salaryReport(StringBuilder resultingHtml) throws Exception;
}
