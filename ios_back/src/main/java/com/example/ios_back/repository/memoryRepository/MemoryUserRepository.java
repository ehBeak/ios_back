package com.example.ios_back.repository.memoryRepository;

import com.example.ios_back.domain.User;
import com.example.ios_back.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements UserRepository {

    private static Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Optional<User> findUserByUsername(String username) {
        return store.values().stream()
                .filter(member -> member.getName().equals(username))
                .findAny();
    }

    @Override
    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public void login() {

    }

    @Override
    public void withdraw() {

    }

    @Override
    public void addFriend() {

    }

    @Override
    public void removeFriend() {

    }
}
