package by.itacademy.repository;

import by.itacademy.config.TestConfig;
import by.itacademy.entity.GymProgram;
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
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class GymRepositoryRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private GymProgramRepository gymProgramRepository;

    @Before
    public void begin() {
        databaseHelper.init();
    }

    @Test
    public void checkSave(){
        GymProgram savedProgram = gymProgramRepository.save(new GymProgram("program7", trainer1,bodyHigh,
                100));
        assertThat(savedProgram.getName(). equalTo("program7"));
    }

    @Test
    public void checkFindAll(){
        Iterable<GymProgram> programs = gymProgramRepository.findAll();
        List<Object> values = new ArrayList<>();
        programs.forEach(values::add);
        final int expectedSize = 6;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkFindAllByTrainerNameLike(){
        Iterable<GymProgram> programs = gymProgramRepository.findAllByTrainerNameLike("%1%");
        List<GymProgram> values = new ArrayList<>();
        programs.forEach(values::add);
        final int expectedSize = 2;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkDelete(){
        gymProgramRepository.delete(program1);
        Iterable<GymProgram> programs = gymProgramRepository.findAll();
        List<GymProgram> values = new ArrayList<>();
        programs.forEach(values::add);
        final int expectedSize = 5;
        assertThat(values, hasSize(expectedSize));
    }
}
