package by.epam.lab.service;

import by.epam.lab.bean.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(int id);

    Optional<User> register(String user);

    void setStartingIdAsZero();
}
