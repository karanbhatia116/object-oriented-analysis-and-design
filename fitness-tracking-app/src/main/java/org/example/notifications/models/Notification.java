package org.example.notifications.models;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public class Notification {
    private final String id;
    private final NotificationType notificationType;
    private final String title;
    private final Instant notificationTimestamp;
    private final Map<String, Object> additionalData;

    public Notification(NotificationType notificationType, String title, Instant notificationTimestamp, Map<String, Object> additionalData) {
        this.additionalData = additionalData;
        this.id = UUID.randomUUID().toString();
        this.notificationType = notificationType;
        this.title = title;
        this.notificationTimestamp = notificationTimestamp;
    }

    public String getId() {
        return id;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getTitle() {
        return title;
    }

    public Instant getNotificationTimestamp() {
        return notificationTimestamp;
    }

    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }

}

