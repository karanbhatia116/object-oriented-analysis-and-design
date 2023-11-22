package org.example.notifications.managers;

import org.example.notifications.observers.Observer;

public interface NotificationManager {
    void notifyObserver(Observer observer);
}
