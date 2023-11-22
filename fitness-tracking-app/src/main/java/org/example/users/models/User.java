package org.example.users.models;


import org.example.notifications.observers.Observer;

import java.util.UUID;

public class User extends Observer {
    private final String id;
    private final String name;
    private int rewardsWon;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRewardsWon() {
        return rewardsWon;
    }

    public void setRewardsWon(int rewardsWon) {
        this.rewardsWon = rewardsWon;
    }
}
