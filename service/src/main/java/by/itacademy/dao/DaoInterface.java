package by.itacademy.dao;

import java.io.Serializable;
import java.util.List;

public interface DaoInterface<T, Id extends Serializable> {

    Id save(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();
}
