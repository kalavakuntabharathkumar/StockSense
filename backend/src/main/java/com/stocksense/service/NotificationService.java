package com.stocksense.service;
import com.sendgrid.*;import com.sendgrid.helpers.mail.Mail;import com.sendgrid.helpers.mail.objects.*;import org.springframework.beans.factory.annotation.Value;import org.springframework.stereotype.Service;import java.io.IOException;
@Service public class NotificationService{
 @Value("${sendgrid.api-key:}")private String apiKey;@Value("${sendgrid.from:}")private String from;
 public boolean configured(){return apiKey!=null&&!apiKey.isBlank()&&from!=null&&!from.isBlank();}
 public String sendLowStock(String to,String product,int quantity){if(!configured())return "SendGrid is not configured; alert was not sent";Email f=new Email(from);Email t=new Email(to);Content c=new Content("text/plain","Low stock alert: "+product+" has "+quantity+" units remaining.");Mail mail=new Mail(f,"StockSense low-stock alert",t,c);SendGrid sg=new SendGrid(apiKey);Request req=new Request();try{req.setMethod(Method.POST);req.setEndpoint("mail/send");req.setBody(mail.build());Response res=sg.api(req);if(res.getStatusCode()>=200&&res.getStatusCode()<300)return "Alert sent";throw new IllegalStateException("SendGrid returned HTTP "+res.getStatusCode());}catch(IOException e){throw new IllegalStateException("SendGrid request failed",e);}}
}
