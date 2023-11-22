package org.example.notifications.subjects;

import java.util.UUID;

public class Subject {
    private final String id;

    public Subject() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
