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

    public Notification(int notificationID, int studentID, String message, int channel, String to, LocalDateTime scheduledTime, LocalDateTime deliveredTime) {
        this.notificationID = notificationID;
        this.studentID = studentID;
        this.message = message;
        this.channel = channel;
        this.to = to;
        this.scheduledTime = scheduledTime;
        this.deliveredTime = deliveredTime;
    }

    public int getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public LocalDateTime getDeliveredTime() {
        return deliveredTime;
    }

    public void setDeliveredTime(LocalDateTime deliveredTime) {
        this.deliveredTime = deliveredTime;
    }
}
