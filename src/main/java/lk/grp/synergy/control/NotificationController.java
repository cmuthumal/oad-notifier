package lk.grp.synergy.control;

import lk.grp.synergy.db.NotificationDAO;
import lk.grp.synergy.model.Notification;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by CM on 2017-02-13.
 */
public class NotificationController {
    private NotificationDAO notificationDAO;

    public NotificationController() {
        notificationDAO = new NotificationDAO();
    }

    public ArrayList<Notification> getPendingNotifications() throws SQLException, NamingException, ClassNotFoundException {
        return notificationDAO.getPendingNotifications();
    }
}
