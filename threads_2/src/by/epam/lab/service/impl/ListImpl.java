package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;


public class ListImpl implements UserService {
    private final List<User> users;
    private final ReentrantLock lock = new ReentrantLock();
    private static int id;

    public ListImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public Optional<User> getUser(int id) {
        if (id < 0 || id >= users.size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> register(String userName) {
        lock.lock();
        try {
            for (User currentUser : users) {
                if (userName.equals(currentUser.getAccount())) {
                    return Optional.empty();
                }
            }
            if (!users.isEmpty()) {
                id = users.size();
            }
            User user = new User(userName, id);
            users.add(user);
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
