package lk.grp.synergy;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

    public static void main(String[] args) {

        final String username = "isurub1992@gmail.com";
        final String password = "d3v@*nix";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("isurub1992@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("2222cm@gmail.com"));
            message.setSubject("Testing");
            message.setText("Hi,\nThis is a test e-mail from OUSL-OAD.");

            Transport.send(message);
            System.out.println("Sent.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}