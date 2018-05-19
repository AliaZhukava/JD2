package by.itacademy.dao;

import by.itacademy.entity.Training;
import by.itacademy.entity.enum_entity.Level;
import org.junit.Assert;
import org.junit.Test;

public class TrainingDaoTest {

    private static final TrainingDao dao = TrainingDao.getInstance();

    @Test
    public void saveTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());
        Training t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(t.getName(), "test1");
    }

    @Test
    public void saveAndDeleteTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());

        Training t = dao.findById(id);
        dao.delete(t);
        t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertNull(t);
    }

    @Test
    public void saveAndUpdateTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());

        Training t = dao.findById(id);
        t.setName("test2");
        dao.update(t);
        t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(t.getName(), "test2");
    }

    private static Training makeTestClient() {
        return new Training("test1", Level.EASY);
    }
}

