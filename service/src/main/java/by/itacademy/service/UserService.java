package by.itacademy.service;

import by.itacademy.dao.ClientDao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public List<String> findAll() {
        return  ClientDao.getInstance().findAll().stream()
                .map(it -> it.getName())
                .collect(Collectors.toList());
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
