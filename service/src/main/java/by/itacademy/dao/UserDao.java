package by.itacademy.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserDao {

    public final static UserDao INSTANCE = new UserDao();

    public List<String> findAll() {
        List<String> users = new ArrayList<>();
        users.add("Ivan");
        users.add("Piter");
        users.add("Ann");

        return users;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

}

