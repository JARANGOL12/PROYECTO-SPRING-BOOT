package com.sise.restaurant_api.shared;

import javax.el.ELException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailSender {

    private JavaMailSender mailSender;

public EmailSender(JavaMailSender mailSender) {
this.mailSender = mailSender;
}

public void sendEmail(String [] emailsTo, String [] emailsCC, String [] emailsBCC,String subject, String content) throws Exception  {
MimeMessage message = mailSender.createMimeMessage();
MimeMessageHelper helper = new MimeMessageHelper(message);

helper.setFrom("jarango121299@gmail.com", "Soy Arango");
helper.setTo(emailsTo);
if(emailsTo != null && emailsCC.length >0){
      helper.setBcc(emailsCC);
}
if(emailsBCC != null && emailsBCC.length >0){
      helper.setBcc(emailsBCC);
}

helper.setSubject(subject);
helper.setText(content, true);

mailSender.send(message);
}
}
