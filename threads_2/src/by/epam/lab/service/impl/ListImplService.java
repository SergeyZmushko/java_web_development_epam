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
    private final ReentrantLock lock = new ReentrantLock();

    public ListImplService(List<User> users) {
        this.users = users;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<User> resultUser = Optional.empty();
        Optional<User> user = IntStream.of(id)
                .filter(ind -> ind >= 0 && ind < users.size())
                .mapToObj(users::get)
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
            Optional<User> user = users.stream()
                    .filter(u -> userName.equals(u.getAccount()))
                    .findAny();
            if (user.isEmpty()) {
                resultUser = Optional.of(new User(userName, users.size() + 1));
                users.add(resultUser.get());
            } else {
                System.out.println(Constants.REGISTERED_USER + user.get());
            }
            return resultUser;
        } finally {
            lock.unlock();
        }
    }
}
