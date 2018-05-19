package by.itacademy.dao;

import by.itacademy.entity.GymProgram;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GymProgramDao extends BaseDao implements DaoInterface<GymProgram, Long> {

    public final static GymProgramDao INSTANCE = new GymProgramDao();

    public static GymProgramDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long save(GymProgram entity) {
        return (Long)getCurrentSession().save(entity);
    }

    @Override
    public void update(GymProgram entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public GymProgram findById(Long id) {
        GymProgram GymProgram = getCurrentSession().get(GymProgram.class, id);
        return GymProgram;
    }

    @Override
    public void delete(GymProgram entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<GymProgram> findAll() {
        List<GymProgram> gymPrograms = getCurrentSession().createQuery("from GymProgram").list();
        return gymPrograms;
    }
}
