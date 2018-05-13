package by.itacademy.dao;

import by.itacademy.entity.Trainer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TrainerDao extends BaseDao implements DaoInterface<Trainer, Long>{

    public final static TrainerDao INSTANCE = new TrainerDao();

    public static TrainerDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long save(Trainer entity) {
        return (Long)getCurrentSession().save(entity);
    }

    @Override
    public void update(Trainer entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Trainer findById(Long id) {
        Trainer trainer = getCurrentSession().get(Trainer.class, id);
        return trainer;

    }

    @Override
    public void delete(Trainer entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Trainer> findAll() {
        List<Trainer> trainers = getCurrentSession().createQuery("from Trainer").list();
        return trainers;
    }
}
