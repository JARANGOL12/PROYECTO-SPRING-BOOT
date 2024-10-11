package com.sise.restaurant_api.services.impl;


import com.sise.restaurant_api.payload.request.EmailRequest;
import com.sise.restaurant_api.services.IEmailService;
import com.sise.restaurant_api.shared.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements IEmailService {

      @Autowired
      JavaMailSender javaMailSender;
  
      @Override
      public void sendWelcome(EmailRequest emailRequest) throws Exception {
       
        new EmailSender(javaMailSender)
            .sendEmail(
                emailRequest, 
                "TENGO HAMBRE'S - GRACIAS POR REGISTRARTE", 
                buildHtmlTemplate(
                    new StringBuilder()
                    .append(buildOneColumn("Gracias", "GRACIAS POR REGISTRARTE"))
                    .append(buildOneColumn("", ""))
                    .toString()
                )
            );
      }
  
      @Override
      public void sendNotice(EmailRequest emailRequest) throws Exception {
      
        new EmailSender(javaMailSender)
            .sendEmail(
                emailRequest, 
                "TENGO HAMBRE'S  BRAZY  POR QUE NO ME DAS COMIDA ", 
                buildTableMaster("Tengo demasiado hambre brazy es mala no me quiere dar comida")
                
               
            );
      }
    

      private String buildHtmlTemplate(String body){
        return new StringBuilder()
                .append("<!DOCTYPE PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “https://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>")
                .append("<html xmlns=\"http://www.w3.org/1999/xhtml\">")
                .append("<head>")
                    .append("<meta charset=\"UTF-8\">")
                    .append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\">")
                    .append("<title></title>")
                .append("</head>")
                .append("<body>")
                    .append(body)
                .append("</body>")
                .append("</html>")
                .toString();
    }
    private String buildTableMaster(String body){
        return new StringBuilder()
        .append("<table style=\"background-color:#f2f2f2; width:100%;\">")  // Corregido "witdh" a "width"
        .append("<tbody>")
        .append("<tr>")
        .append("<td>")
        .append("<table style=\"background-color:white; width:400px; margin-left:auto; margin-right:auto;\">")
        .append("<tbody>")
        
        // Fila con el logo o imagen
        .append("<tr style=\"background-color:#48e;padding:5px 7px;\">") // Corregido padding
        .append("<td>")
        .append("<img src=\"https://drive.google.com/uc?export=view&id=1Hu11AwgKPLu7N_xtzpzkYaSHnJlwUJJV\" alt=\"Image\" style=\"width:50%;\">") // Corregido el uso de width
        .append("</td>")
        .append("</tr>")

        // Fila con el texto del restaurante
        .append("<tr style=\"background-color:#48e;padding:5px 7px;\">")
        .append("<td>")
        .append("<h2 style=\"margin:0px;color:white;width:100%;text-align:center;\">RESTAURANTE TENGO HAMBE'S</h2>")
        .append("<h4 style=\"margin:0px;margin-top:3px;font-weight:normal;color:white;width:100%;text-align:center;\">Av Arequipa 2020 - Santa Beatriz</h4>") // Corregido margin y color
        .append("</td>")
        .append("</tr>")

        .append("<tr>")
        .append("<td>")
        .append(body)  // Se añade el contenido del body
        .append("</td>")
        .append("</tr>")

        .append("</tbody>")
        .append("</table>")
        .append("</td>")
        .append("</tr>")
        .append("</tbody>")
        .append("</table>")
        .toString();
    }
 private String buildOneColumn(String campo, String valor){
    return new StringBuilder()

    .toString();
 }
  
}
