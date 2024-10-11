package com.sise.restaurant_api.shared;
  


import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.sise.restaurant_api.payload.request.EmailRequest;

public class EmailSender {

      private JavaMailSender mailSender;

      public EmailSender(JavaMailSender mailSender) {
          this.mailSender = mailSender;
      }
  
      public void sendEmail(EmailRequest emailRequest, String subject, String content) throws Exception {
          MimeMessage message = mailSender.createMimeMessage();
          MimeMessageHelper helper = new MimeMessageHelper(message);
  
          helper.setFrom("jarango121299@gmail.com", "Soy Jose");
          helper.setTo(emailRequest.getEmailsTo());
          if(emailRequest.getEmailsCC() != null && emailRequest.getEmailsCC().length > 0) {
              helper.setCc(emailRequest.getEmailsCC());
          }
          if(emailRequest.getEmailsBCC() != null && emailRequest.getEmailsBCC().length> 0){
              helper.setBcc(emailRequest.getEmailsBCC());
          }
          helper.setSubject(subject);
          helper.setText(content, true);
  
          mailSender.send(message);
      }
}
