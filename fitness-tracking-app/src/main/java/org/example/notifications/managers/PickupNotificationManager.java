package org.example.notifications.managers;

import org.example.notifications.observers.Observer;
import org.example.users.models.User;

public class PickupNotificationManager implements NotificationManager {

    @Override
    public void notifyObserver(Observer observer) {
        User user = (User) observer;
        System.out.println(
                "User " + user.getName()
                        + ". You can do it! Keep at it and all goals would look small"
        );
    }
}
