package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.service.UserService;
import by.epam.lab.utils.Constants;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class MapImplService implements UserService {
    private final Map<Integer, String> users;
    private final ReentrantLock lock;

    public MapImplService(Map<Integer, String> users, ReentrantLock lock) {
        this.users = users;
        this.lock = lock;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<User> user = users.entrySet()
                .stream()
                .filter(k -> id == k.getKey())
                .map(a -> new User(a.getValue(), a.getKey()))
                .findAny();
        if (user.isEmpty()){
            System.out.println(Constants.NOT_EXIST_USER + id);
        }
        return user;
    }

    @Override
    public Optional<User> register(String account) {
        lock.lock();
        try {
            Optional<User> user = users.entrySet().stream()
                    .filter(u -> users.containsValue(account))
                    .map(u -> new User(u.getValue(), u.getKey()))
                    .findAny();
            if (user.isEmpty()) {
                user = Optional.of(new User(account, users.size() + 1));
                users.put(user.get().getId(), user.get().getAccount());
            } else {
                System.out.println(Constants.REGISTERED_USER + user.get());
            }
            return user;
        } finally {
            lock.unlock();
        }
    }
}
