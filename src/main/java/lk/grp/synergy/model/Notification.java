package lk.grp.synergy.model;

import java.time.LocalDateTime;

/**
 * Created by CM on 2017-02-13.
 */
public class Notification {
    private int notificationID;
    private int studentID;
    private String message;
    private int channel;
    private String to;
    private LocalDateTime scheduledTime;
    private LocalDateTime deliveredTime;
}
