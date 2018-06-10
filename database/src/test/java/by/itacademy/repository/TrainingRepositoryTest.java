package by.itacademy.repository;

import by.itacademy.config.TestConfig;
import by.itacademy.entity.Training;
import by.itacademy.entity.enum_entity.Level;
import by.itacademy.util.DatabaseHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class TrainingRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private TrainingRepository trainingRepository;

    @Before
    public void begin() {
        databaseHelper.init();
    }

    @Test
    public void checkSave() {
        Training savedTraining = trainingRepository.save(new Training("fitnessHigh", Level.HIGH));
        assertNotNull(savedTraining);
    }

    @Test
    public void checkFindAll() {
        Iterable<Training> trainings = trainingRepository.findAll();
        List<Training> values = new ArrayList<>();
        trainings.forEach(values::add);
        final int expectedSize = 3;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkDelete() {
        trainingRepository.delete(fitnessEasy);
        Iterable<Training> trainings = trainingRepository.findAll();
        List<Training> values = new ArrayList<>();
        trainings.forEach(values::add);
        final int expectedSize = 2;
        assertThat(values, hasSize(expectedSize));
    }
}
