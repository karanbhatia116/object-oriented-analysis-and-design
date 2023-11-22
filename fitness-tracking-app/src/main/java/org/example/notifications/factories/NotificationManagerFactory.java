package org.example.notifications.factories;

import org.example.notifications.managers.MotivationNotificationManager;
import org.example.notifications.managers.NotificationManager;
import org.example.notifications.managers.PickupNotificationManager;
import org.example.notifications.models.NotificationType;

public class NotificationManagerFactory {
    private final NotificationManager motivationNotificationManager;
    private final NotificationManager pickupNotificationManager;

    public NotificationManagerFactory(NotificationManager motivationNotificationManager, NotificationManager pickupNotificationManager) {
        this.motivationNotificationManager = (MotivationNotificationManager) motivationNotificationManager;
        this.pickupNotificationManager = (PickupNotificationManager) pickupNotificationManager;
    }

    public NotificationManager getNotificationManager(NotificationType notificationType) {
        switch (notificationType) {
            case PICKUP:
                return pickupNotificationManager;
            case MOTIVATION:
                return motivationNotificationManager;
            default:
                return null;
        }
    }
}
