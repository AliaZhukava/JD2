package by.itacademy.dao;

import by.itacademy.entity.GymProgram;
import by.itacademy.entity.Trainer;
import by.itacademy.entity.Training;
import by.itacademy.entity.enum_entity.Category;
import by.itacademy.entity.enum_entity.GymUserRole;
import by.itacademy.entity.enum_entity.Level;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.UUID;

public class GymProgramDaoTest {

    private static final GymProgramDao dao = GymProgramDao.getInstance();

    @Before
    public void clean() {
        try (Session session = dao.openCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from GymProgram").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());
        GymProgram t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(t.getName(), "program name");
    }

    @Test
    public void saveAndDeleteTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());

        GymProgram t = dao.findById(id);
        dao.delete(t);
        t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertNull(t);
    }

    @Test
    public void saveAndUpdateTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());

        GymProgram t = dao.findById(id);
        t.setName("test5");
        dao.update(t);
        t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(t.getName(), "test5");
    }

    private static GymProgram makeTestClient() {
        TrainerDao dao3 = TrainerDao.getInstance();
        Trainer c = new Trainer(UUID.randomUUID().toString(), "pass", GymUserRole.USER,
                UUID.randomUUID().toString(), 3759999L, UUID.randomUUID().toString(),
                Category.FIRST);
        dao3.openCurrentSession();
        Long id = dao3.save(c);
        c = dao3.findById(id);
        dao3.closeCurrentSession();

        TrainingDao dao4 = TrainingDao.getInstance();
        Training t = new Training("training", Level.EASY);
        dao4.openCurrentSession();
        id = dao4.save(t);
        t = dao4.findById(id);
        dao4.closeCurrentSession();
        return new GymProgram("program name", c, t, new Time(9, 0, 0), "Friday", 120);
    }
}
