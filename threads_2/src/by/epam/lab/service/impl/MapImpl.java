package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.service.Command;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MapImpl implements Command {
    private final Map<Integer, String> users;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    public static int id;
    private final CountDownLatch countDownLatch;

    public MapImpl(Map<Integer, String> users, CountDownLatch countDownLatch) {
        this.users = users;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public Optional<User> getUser(int id) {
        readLock.lock();
        try {
            Optional<String> account = Optional.ofNullable(users.get(id));
            if (account.isPresent()){
                User user = new User(users.get(id), id);
                return Optional.of(user);
            }else {
                return Optional.empty();
            }
        }finally {
            readLock.unlock();
        }
    }

    @Override
    public Optional<User> register(User user) {
        writeLock.lock();
        try {
            if (users.containsValue(user.getAccount())){
                countDownLatch.countDown();
                return Optional.empty();
            }
            if (!users.isEmpty()) {
                id = users.size();
            }
            user.setId(id);
            users.put(id, user.getAccount());
            id++;
            countDownLatch.countDown();

        } finally {
            writeLock.unlock();
        }
        return Optional.of(user);
    }
}
