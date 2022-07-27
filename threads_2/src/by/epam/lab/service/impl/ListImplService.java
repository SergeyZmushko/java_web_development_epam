package by.epam.lab.service.impl;

import by.epam.lab.bean.User;
import by.epam.lab.utils.Constants;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ListImplService extends AbstractService {
    private final List<User> users;

    public ListImplService(List<User> users) {
        super();
        this.users = users;
    }

    @Override
    public Optional<User> getUser(int id) {
        Optional<User> user = IntStream.of(id)
                .filter(ind -> ind >= 0 && ind < users.size())
                .mapToObj(users::get)
                .findAny();
        if (user.isEmpty()) {
            System.out.println(Constants.NOT_EXIST_USER + id);
        }
        return user;
    }

    @Override
    protected List<User> getModelForSearch() {
        return users;
    }

    @Override
    protected void addUserToModel(User user) {
        users.add(user);
    }
}
