package org.example.notifications.observers;

import java.util.UUID;

public class Observer {
    private final String id;

    public Observer() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
