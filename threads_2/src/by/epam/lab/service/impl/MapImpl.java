package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.service.UserService;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class MapImpl implements UserService {
    private final Map<Integer, String> users;
    private final ReentrantLock lock = new ReentrantLock();
    private static int id;


    public MapImpl(Map<Integer, String> users) {
        this.users = users;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<String> account = Optional.ofNullable(users.get(id));
        if (account.isPresent()) {
            User user = new User(users.get(id), id);
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> register(String userName) {
        lock.lock();
        try {
            if (users.containsValue(userName)) {
                return Optional.empty();
            }
            if (!users.isEmpty()) {
                id = users.size();
            }
            User user = new User(userName, id);
            users.put(user.getId(), user.getAccount());
            id++;
            return Optional.of(user);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void setStartingIdAsZero() {
        id = 0;
    }
}
