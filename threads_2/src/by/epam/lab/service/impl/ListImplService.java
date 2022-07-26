package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.service.UserService;
import by.epam.lab.utils.Constants;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ListImplService implements UserService {
    private final List<User> users;
    private final ReentrantLock lock;

    public ListImplService(List<User> users, ReentrantLock lock) {
        this.users = users;
        this.lock = lock;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<User> user = IntStream.of(id)
                .filter(ind -> ind >= 0 && ind < users.size())
                .mapToObj(users::get)
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
            Optional<User> user = users.stream()
                    .filter(u -> account.equals(u.getAccount()))
                    .findAny();
            if (user.isEmpty()) {
                users.add(Optional.of(new User(account, users.size() + 1)).get());
            } else {
                System.out.println(Constants.REGISTERED_USER + user.get());
            }
            return user;
        } finally {
            lock.unlock();
        }
    }
}
