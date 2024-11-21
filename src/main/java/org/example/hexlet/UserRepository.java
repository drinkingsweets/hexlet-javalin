package org.example.hexlet;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> entities = new ArrayList<>();

    public static void add(User user) {
        entities.add(user);
    }

    public static boolean checkUser(String login, String password) {
        for(User user: entities) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
