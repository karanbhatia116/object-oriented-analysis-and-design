package org.example.users.managers;

import org.example.users.db.UserDbService;
import org.example.users.models.User;

public class UserManagerImpl implements UserManager {

    private final UserDbService userDbService;

    public UserManagerImpl(UserDbService userDbService) {
        this.userDbService = userDbService;
    }

    @Override
    public User getUser(String userId) {
        return userDbService.getUser(userId);
    }

    @Override
    public void addRewardsForUser(int rewards, String userId) {
        User user = userDbService.getUser(userId);
        user.setRewardsWon(user.getRewardsWon() + rewards);
        userDbService.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        userDbService.createUser(user);
    }
}
