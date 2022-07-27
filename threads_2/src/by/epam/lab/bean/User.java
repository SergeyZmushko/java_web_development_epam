package by.epam.lab.bean;

import static by.epam.lab.utils.Constants.*;

public class User {
    private final String account;
    private int id;

    public User(String account){
        this.account = account;
    }

    public User(String account, int id) {
        this(account);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String toString() {
        return account + DELIMITER + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && account.equals(user.account);
    }

    @Override
    public int hashCode() {
        int result = account.hashCode();
        result = PRIMARY_NUMBER * result + id;
        return result;
    }
}
