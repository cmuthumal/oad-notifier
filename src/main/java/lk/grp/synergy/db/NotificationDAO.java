package lk.grp.synergy.db;

import lk.grp.synergy.model.Notification;

import javax.naming.NamingException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

/**
 * Created by CM on 2017-02-13.
 */
public class NotificationDAO {

    public NotificationDAO() {

    }

    public ArrayList<Notification> getPendingNotifications() throws SQLException, NamingException, ClassNotFoundException {
        ArrayList<Notification> notifications = new ArrayList();
        String sql = "SELECT * FROM notification WHERE delivered_time IS NULL;";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement prStmt = con.prepareStatement(sql)
        ) {
            ResultSet resultSet = prStmt.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("notification_id");
                    String msg = resultSet.getString("message");
                    int channel = resultSet.getInt("channel");
                    String to = resultSet.getString("to");
                    LocalDateTime scheduledTime = resultSet.getTimestamp("scheduled_time").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    LocalDateTime deliveredTime = null;
                    int stdId = resultSet.getInt("student_id");

                    notifications.add(new Notification(id, stdId, msg, channel, to, scheduledTime, deliveredTime));
                }
            }
        }

        return notifications;
    }

    public boolean setSentNotifications(Notification n) throws SQLException, NamingException, ClassNotFoundException {
        String sql = "UPDATE notification SET delivered_time=? WHERE notification_id=?;";
        boolean updated = false;
        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement(sql)
        ) {
            pstm.setTimestamp(1,Timestamp.valueOf(LocalDateTime.now()));
            pstm.setInt(2,n.getNotificationID());

            updated = pstm.executeUpdate() == 1;
        }
        return updated;
    }
}
