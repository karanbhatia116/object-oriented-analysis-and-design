package org.example.users.managers;

import org.example.users.models.User;

public interface UserManager {
    User getUser(String userId);

    void addRewardsForUser(int rewards, String userId);

    void addUser(User user);
}
