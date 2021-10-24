package com.ratnikov.dao;

import com.ratnikov.user.User;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    @Getter
    private final List<User> users;

    private static int USER_COUNT;
    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT,"Roy","boxer"));
        users.add(new User(++USER_COUNT,"Bruce","karate"));
        users.add(new User(++USER_COUNT,"Sam","fireman"));
    }

    public User findUserByCode(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public void add(String name, String login) {
        users.add(new User(++USER_COUNT, name, login));
    }

    public boolean update(int id, String name, String login) {
        if (id == 0) {
            return false;
        }
        final User user = findUserByCode(id);
        user.setLogin(login);
        user.setName(name);
        return true;
    }
}
