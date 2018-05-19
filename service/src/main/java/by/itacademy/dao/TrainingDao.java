package by.itacademy.dao;

import by.itacademy.entity.Training;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TrainingDao extends BaseDao implements DaoInterface<Training, Long>{

    public final static TrainingDao INSTANCE = new TrainingDao();

    public static TrainingDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long save(Training entity) {
        return (Long)getCurrentSession().save(entity);
    }

    @Override
    public void update(Training entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Training findById(Long id) {
        Training training = getCurrentSession().get(Training.class, id);
        return training;
    }

    @Override
    public void delete(Training entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Training> findAll() {
        List<Training> trainings = getCurrentSession().createQuery("from Training").list();
        return trainings;
    }
}
