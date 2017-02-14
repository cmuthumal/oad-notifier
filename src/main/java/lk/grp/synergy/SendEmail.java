package lk.grp.synergy;

import lk.grp.synergy.control.NotificationController;
import lk.grp.synergy.model.Notification;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;

public class SendEmail {

    public static void main(String[] args) {
        sendEmail();
    }

    private static void sendEmail() {
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

        NotificationController notificationController = new NotificationController();
        ArrayList<Notification> notifications;

        try {
            notifications = notificationController.getPendingNotifications();

            for (int i = 0; i < notifications.size(); i++) {
                Notification n = notifications.get(i);
                Message message = new MimeMessage(session);

                message.setFrom(new InternetAddress("isurub1992@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(n.getTo()));
                message.setSubject("Activity Update");
                message.setText(n.getMessage());

                Transport.send(message);

                notificationController.setSentNotifications(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
