package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.service.Command;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ListImpl implements Command {
    private final List<User> users;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    public static int id;
    private final CountDownLatch countDownLatch;

    public ListImpl(List<User> users, CountDownLatch countDownLatch) {
        this.users = users;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Optional<User> getUser(int id) {
        readLock.lock();
        try {
            if (id < 0 || id >= users.size()){
              return Optional.empty();
            }
        } finally {
            readLock.unlock();
        }
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> register(User user) {
        writeLock.lock();
        try {
            for (User currentUser : users) {
                if (user.getAccount().equals(currentUser.getAccount())) {
                    countDownLatch.countDown();
                    return Optional.empty();
                }
            }
            if (!users.isEmpty()) {
                id = users.size();
            }
            user.setId(id);
            users.add(user);
            id++;
            countDownLatch.countDown();
        } finally {
            writeLock.unlock();
        }
        return Optional.of(user);
    }
}
