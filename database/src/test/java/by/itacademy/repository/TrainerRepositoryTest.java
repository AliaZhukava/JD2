package by.itacademy.repository;

import by.itacademy.config.TestConfig;
import by.itacademy.entity.Trainer;
import by.itacademy.entity.enum_entity.Category;
import by.itacademy.entity.enum_entity.GymUserRole;
import by.itacademy.util.DatabaseHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class TrainerRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private TrainerRepository trainerRepository;

    @Before
    public void begin() {
        databaseHelper.init();
    }

    @Test
    public void checkSave(){
        Trainer savedTrainer = trainerRepository.save(new Trainer("login11", "pass1", GymUserRole.USER, "name11",
                375291000000L, "email10", Category.FIRST));
        assertThat(savedTrainer.getName(). equalTo("name11"));
    }

    @Test
    public void checkFindAll(){
        Iterable<Trainer> trainers = trainerRepository.findAll(PageRequest.of(0, 2));
        List<Trainer> values = new ArrayList<>();
        trainers.forEach(values::add);
        final int expectedSize = 3;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkFindAllByCategory(){
        Iterable<Trainer> trainers = trainerRepository.findAllByCategory(Category.FIRST);
        List<Trainer> values = new ArrayList<>();
        trainers.forEach(values::add);
        final int expectedSize = 1;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkFindAllByGymPrograms() {
        Iterable<Trainer> trainers = trainerRepository.findAllByGymPrograms(program1, PageRequest.of(0, 2));
        List<Trainer> values = new ArrayList<>();
        trainers.forEach(values::add);
        final int expectedSize = 1;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkDelete(){
        trainerRepository.delete(trainer1);
        Iterable<Trainer> clients = trainerRepository.findAll();
        List<Trainer> values = new ArrayList<>();
        clients.forEach(values::add);
        final int expectedSize = 2;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkUpdate(){
        Category actual = trainerRepository.updateTrainer(Category.TOP, "trainer1");
        final Category expected = Category.TOP;
        assertEquals(expected, actual);
    }
}
