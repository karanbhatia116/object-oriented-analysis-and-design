package org.example.users.db;

import org.example.exceptions.InvalidOperationException;
import org.example.exceptions.NotFoundException;
import org.example.users.models.User;

import java.util.HashMap;
import java.util.Map;

public class HashMapUserDbServiceImpl implements UserDbService {

    Map<String, User> userDb = new HashMap<>(0);

    @Override
    public void createUser(User user) {
        userDb.put(user.getId(), user);
    }

    @Override
    public User getUser(String id) {
        if (!userDb.containsKey(id))
            throw new NotFoundException("User with id not found!");
        return userDb.get(id);
    }

    @Override
    public void updateUser(User user) {
        userDb.put(user.getId(), user);
    }

    @Override
    public void deleteUser(String id) {
        if (!userDb.containsKey(id))
            throw new InvalidOperationException("Failed to delete user with id since user with id not found!");
        userDb.remove(id);
    }
}
