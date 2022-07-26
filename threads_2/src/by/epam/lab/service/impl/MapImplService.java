package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class MapImplService extends AbstractService {
    private final Map<Integer, User> users;

    public MapImplService(ReentrantLock lock, Map<Integer, User> users) {
        super(lock);
        this.users = users;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<User> user = users.entrySet()
                .stream()
                .filter(k -> k.getKey() == id)
                .map(Map.Entry::getValue)
                .findAny();
        if (user.isEmpty()) {
            System.out.println(Constants.NOT_EXIST_USER + id);
        }
        return user;
    }

    @Override
    protected List<User> getModelForSearch() {
        return new ArrayList<>(users.values());
    }

    @Override
    protected void addUserToModel(User user) {
        users.put(user.getId(), user);
    }
}
