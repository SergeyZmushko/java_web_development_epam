package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.service.UserService;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractService implements UserService {
    private final ReentrantLock lock;

    public AbstractService() {
        this.lock = new ReentrantLock();
    }

    public Optional<User> register(String account) {
        lock.lock();
        try {
            if (getModelForSearch().stream()
                    .noneMatch(user -> account.equals(user.getAccount()))) {
                User user = new User(account, getModelForSearch().size() + 1);
                addUserToModel(user);
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } finally {
            lock.unlock();
        }
    }

    protected abstract Collection<User> getModelForSearch();

    protected abstract void addUserToModel(User user);
}
