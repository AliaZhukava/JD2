package by.itacademy.util;

import by.itacademy.entity.Client;
import by.itacademy.entity.ClientGymProgram;
import by.itacademy.entity.GymProgram;
import by.itacademy.entity.Review;
import by.itacademy.entity.Trainer;
import by.itacademy.entity.Training;
import by.itacademy.entity.enum_entity.Category;
import by.itacademy.entity.enum_entity.GymUserRole;
import by.itacademy.entity.enum_entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DatabaseHelper {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public DatabaseHelper(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void cleanDatabase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Training").executeUpdate();
        entityManager.createQuery("delete from ClientGymProgram").executeUpdate();
        entityManager.createQuery("delete from Trainer").executeUpdate();
        entityManager.createQuery("delete from GymProgram").executeUpdate();
        entityManager.createQuery("delete from Client").executeUpdate();
        entityManager.createQuery("delete from Review").executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void prepareData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Training fitnessEasy = new Training("Fitness", Level.EASY);
        Training crossMedium = new Training("Crossfit", Level.MEDIUM);
        Training bodyHigh = new Training("Bodybuilding", Level.HIGH);
        entityManager.persist(fitnessEasy);
        entityManager.persist(crossMedium);
        entityManager.persist(bodyHigh);

        ClientGymProgram clientGymProgram1 = new ClientGymProgram(LocalTime.of(17, 0), "Понедельник");
        ClientGymProgram clientGymProgram2 = new ClientGymProgram(LocalTime.of(18, 0), "Среда");
        ClientGymProgram clientGymProgram3 = new ClientGymProgram(LocalTime.of(19, 0), "Пятница");
        entityManager.persist(clientGymProgram1);
        entityManager.persist(clientGymProgram2);
        entityManager.persist(clientGymProgram3);

        Trainer trainer1 = new Trainer("tLogin1", "tPass1", GymUserRole.USER, "trainer1",
                375297777777L, "tEmail1", Category.FIRST);
        Trainer trainer2 = new Trainer("tLogin2", "tPass2", GymUserRole.USER, "trainer2",
                375298888888L, "tEmail2", Category.SECOND);
        Trainer trainer3 = new Trainer("tLogin3", "tPass3", GymUserRole.USER, "trainer3",
                375297777777L, "tEmail3", Category.TOP);
        entityManager.persist(trainer1);
        entityManager.persist(trainer2);
        entityManager.persist(trainer3);

        GymProgram program1 = new GymProgram("Program1", trainer1, fitnessEasy, 100);
        GymProgram program2 = new GymProgram("Program2", trainer1, bodyHigh, 200);
        GymProgram program3 = new GymProgram("Program3", trainer2, fitnessEasy, 150);
        GymProgram program4 = new GymProgram("Program4", trainer2, crossMedium, 100);
        GymProgram program5 = new GymProgram("Program5", trainer3, crossMedium, 120);
        GymProgram program6 = new GymProgram("Program6", trainer3, bodyHigh, 100);
        entityManager.persist(program1);
        entityManager.persist(program2);
        entityManager.persist(program3);
        entityManager.persist(program4);
        entityManager.persist(program5);
        entityManager.persist(program6);

        Client user1 = new Client("login1", "pass1", GymUserRole.USER, "name1",
                375291111111L, "email1", 0, clientGymProgram1, program1);
        Client user2 = new Client("login2", "pass2", GymUserRole.USER, "name2",
                375292222222L, "email2", 10, clientGymProgram1, program1);
        Client user3 = new Client("login3", "pass3", GymUserRole.USER, "name3",
                375293333333L, "email3", 20, clientGymProgram2, program2);
        Client user4 = new Client("login4", "pass4", GymUserRole.USER, "name4",
                375294444444L, "email4", 0, clientGymProgram2, program2);
        Client user5 = new Client("login5", "pass5", GymUserRole.USER, "name5",
                375295555555L, "email5", 0);
        Client admin = new Client("admin", "admin", GymUserRole.ADMIN, "admin",
                375296666666L, "email1", 0);
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.persist(user5);
        entityManager.persist(admin);

        Review review1 = new Review(LocalDate.now(), "fggfdgdfgfd", user1);
        Review review2 = new Review(LocalDate.now(), "dfdfdfdfdf", user2);
        Review review3 = new Review(LocalDate.now(), "sfergergrgrg", user3);
        Review review4 = new Review(LocalDate.now(), "sdfbdfbgfgbdfbg", user4);
        entityManager.persist(review1);
        entityManager.persist(review2);
        entityManager.persist(review3);
        entityManager.persist(review4);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
