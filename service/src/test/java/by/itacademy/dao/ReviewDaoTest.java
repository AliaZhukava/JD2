package by.itacademy.dao;

import by.itacademy.entity.Client;
import by.itacademy.entity.Review;
import by.itacademy.entity.enum_entity.GymUserRole;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class ReviewDaoTest {

    private static final ReviewDao dao = ReviewDao.getInstance();

    @Before
    public void clean() {
        try (Session session = dao.openCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from Review").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());
        Review t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertEquals(t.getText(), "test1");
    }

    @Test
    public void saveAndDeleteTest() {
        dao.openCurrentSession();
        Long id = dao.save(makeTestClient());

        Review t = dao.findById(id);
        dao.delete(t);
        t = dao.findById(id);
        dao.closeCurrentSession();

        Assert.assertNull(t);
    }

    private static Review makeTestClient() {
        ClientDao dao2 = ClientDao.getInstance();
        Client c = new Client(UUID.randomUUID().toString(), "pass", GymUserRole.USER,
                UUID.randomUUID().toString(), 3759999L, UUID.randomUUID().toString(),
                52);
        dao2.openCurrentSession();
        Long id = dao2.save(c);
        c = dao2.findById(id);
        dao2.closeCurrentSession();
        return new Review(Date.from(Instant.now()), "test1", c);
    }
}

