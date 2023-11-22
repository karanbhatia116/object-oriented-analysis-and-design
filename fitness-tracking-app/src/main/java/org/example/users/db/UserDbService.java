package org.example.users.db;

import org.example.users.models.User;

public interface UserDbService {
    void createUser(User user);

    User getUser(String id);

    void updateUser(User user);

    void deleteUser(String id);
}
