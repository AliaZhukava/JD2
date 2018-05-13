package by.itacademy.dao;

import by.itacademy.entity.Trainer;
import by.itacademy.entity.enum_entity.Category;
import by.itacademy.entity.enum_entity.GymUserRole;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class TrainerDaoTest {

    private static final TrainerDao dao = TrainerDao.getInstance();

    @Test
    public void saveTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestTrainer());
        Trainer c = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(c.getPassword(), "pass");
    }

    @Test
    public void saveAndDeleteTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestTrainer());

        Trainer t = dao.findById(id);
        dao.delete(t);
        t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertNull(t);
    }

    @Test
    public void saveAndUpdateTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestTrainer());

        Trainer t = dao.findById(id);
        t.setLogin("test4");
        dao.update(t);
        t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(t.getLogin(), "test4");
    }

    private static Trainer makeTestTrainer() {
        return new Trainer(UUID.randomUUID().toString(), "pass", GymUserRole.USER,
                UUID.randomUUID().toString(), 3759999L, UUID.randomUUID().toString(), Category.FIRST);
    }
}

