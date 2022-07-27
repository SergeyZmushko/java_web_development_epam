package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.utils.Constants;

import java.util.*;

public class MapImplService extends AbstractService {
    private final Map<Integer, User> users;

    public MapImplService(Map<Integer, User> users) {
        super();
        this.users = users;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<User> user = Optional.ofNullable(users.get(id));
        if (user.isEmpty()) {
            System.out.println(Constants.NOT_EXIST_USER + id);
        }
        return user;
    }

    @Override
    protected Collection<User> getModelForSearch() {
        return users.values();
    }

    @Override
    protected void addUserToModel(User user) {
        users.put(user.getId(), user);
    }
}
