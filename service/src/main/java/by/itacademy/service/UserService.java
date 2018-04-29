package by.itacademy.service;

import by.itacademy.entity.User;
import by.itacademy.dao.UserDao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public List<User> findAll() {
        return UserDao.getInstance().findAll().stream()
                .map(it -> new User(it.getName)
                .collect(Collectors.toList()));
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
