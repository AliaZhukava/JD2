package by.itacademy.dao;

import by.itacademy.entity.Client;
import by.itacademy.entity.enum_entity.GymUserRole;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class ClientDaoTest {

    private static final ClientDao dao = ClientDao.getInstance();

    @Test
    public void saveTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());
        Client c = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(c.getPassword(), "pass");
    }

    @Test
    public void saveAndDeleteTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());

        Client c = dao.findById(id);
        dao.delete(c);
        c = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertNull(c);
    }

    @Test
    public void saveAndUpdateTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());

        Client c = dao.findById(id);
        c.setLogin("test2");
        dao.update(c);
        c = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(c.getLogin(), "test2");
    }

    private static Client makeTestClient() {
        return new Client(UUID.randomUUID().toString(), "pass", GymUserRole.USER,
                UUID.randomUUID().toString(), 3759999L, UUID.randomUUID().toString(), 52);
    }
}
