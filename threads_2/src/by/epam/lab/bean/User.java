package by.epam.lab.bean;

public class User {
    private final String account;
    private int id;

    public User(String account){
        this.account = account;
    }

    public User(String account, int id){
        this.account = account;
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return account + ";" + id;
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
        result = 31 * result + id;
        return result;
    }
}
