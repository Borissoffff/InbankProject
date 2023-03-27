package com.example.inbankproject.user;

import java.util.List;

public class UserStorage {

    public List<User> getUsers() {
        return List.of(
                new User("49002010965", "Tom", "Cruise", 0),
                new User("49002010976", "Leo", "Messi", 1),
                new User("49002010987", "Tomas", "Platz", 2),
                new User("49002010998", "Larry", "Bird", 3)
        );
    }

    public User getUserByPersonalCode(String personalCode) {
        return getUsers().stream()
                .filter(u -> u.getPersonalCode().equals(personalCode))
                .toList()
                .get(0);
    }
}