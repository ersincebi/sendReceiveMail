package sample.models;

import sample.lib.mailInfo;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class sendMail_Model {
    public sendMail_Model(String user, String password, String toMail, String messageSubject, String messageBody) throws Exception{
        Properties props = new Properties();
        mailInfo info = new mailInfo();
        props.put("mail.smtp.host", info.getSmtpHost());
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.from", user);
        props.put("mail.smtp.auth", "true");
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        };

        Session session = Session.getDefaultInstance(props,auth);

        MimeMessage message = new MimeMessage(session);
        message.setFrom();
        message.setRecipients(Message.RecipientType.TO,toMail);
        message.setSubject(messageSubject);
        message.setSentDate(new Date());
        message.setText(messageBody);
        Transport.send(message);
    }
}
