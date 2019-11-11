package sample.models;

import sample.lib.mailInfo;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class sendMail_Model {
    public sendMail_Model(String toMail, String messageSubject, String messageBody, String filePath) throws Exception{
        Properties props = new Properties();
        mailInfo info = new mailInfo();
        props.put("mail.smtp.host", info.getSmtpHost());
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.from", info.getUser());
        props.put("mail.smtp.auth", "true");
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(info.getUser(),info.getPassword());
            }
        };

        Session session = Session.getDefaultInstance(props,auth);

        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom();
        mimeMessage.setRecipients(Message.RecipientType.TO, toMail);
        mimeMessage.setSubject(messageSubject);
        mimeMessage.setSentDate(new Date());
        Multipart multipart = new MimeMultipart();

        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(messageBody);
        multipart.addBodyPart(bodyPart);

        if(!filePath.isEmpty()) {
            BodyPart partForAtt = new MimeBodyPart();
            DataSource source = new FileDataSource(filePath);
            partForAtt.setDataHandler(new DataHandler(source));
            partForAtt.setFileName(filePath);
            multipart.addBodyPart(partForAtt);
        }

        mimeMessage.setContent(multipart);
        Transport.send(mimeMessage);
    }
}
