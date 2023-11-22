package org.example.notifications.managers;

import org.example.notifications.observers.Observer;
import org.example.users.models.User;

public class MotivationNotificationManager implements NotificationManager {
    @Override
    public void notifyObserver(Observer observer) {
        User user = (User) observer;
        System.out.println(
                "User "
                        + user.getName()
                        + " you are close to completing your goal."
                        + "Continue the progress!"
        );
    }
}
