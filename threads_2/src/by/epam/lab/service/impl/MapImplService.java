package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.service.UserService;
import by.epam.lab.utils.Constants;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class MapImplService implements UserService {
    private final Map<Integer, String> users;
    private final ReentrantLock lock = new ReentrantLock();

    public MapImplService(Map<Integer, String> users) {
        this.users = users;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<User> resultUser = Optional.empty();
        Optional<User> user = users.entrySet().stream()
                .filter(k -> id == k.getKey())
                .map(a -> new User(a.getValue(), a.getKey()))
                .findAny()
                .or(Optional::empty);
        if (user.isEmpty()) {
            System.out.println(Constants.NOT_EXIST_USER + id);
        } else {
            resultUser = user;
        }
        return resultUser;
    }

    @Override
    public Optional<User> register(String userName) {
        lock.lock();
        try {
            Optional<User> resultUser = Optional.empty();
            Optional<User> user = users.entrySet().stream()
                    .filter(u -> users.containsValue(userName))
                    .map(u -> new User(u.getValue(), u.getKey()))
                    .findAny();
            if (user.isEmpty()) {
                resultUser = Optional.of(new User(userName, users.size() + 1));
                users.put(resultUser.get().getId(), resultUser.get().getAccount());
            } else {
                System.out.println(Constants.REGISTERED_USER + user.get());
            }
            return resultUser;
        } finally {
            lock.unlock();
        }
    }
}
