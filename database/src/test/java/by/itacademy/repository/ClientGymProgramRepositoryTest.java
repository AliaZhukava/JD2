package by.itacademy.repository;

import by.itacademy.config.TestConfig;
import by.itacademy.entity.ClientGymProgram;
import by.itacademy.util.DatabaseHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class ClientGymProgramRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private ClientGymProgramRepository clientGymProgramRepository;

    @Before
    public void begin() {
        databaseHelper.init();
    }

    @Test
    public void checkSave() {
        ClientGymProgram savedClientGymProgram = clientGymProgramRepository.save(new ClientGymProgram
                (LocalTime.of(16, 0), "Вторник"));
        assertThat(savedClientGymProgram.getDayOfWeek().equalTo("Вторник"));
    }

    @Test
    public void checkFindAll() {
        Iterable<ClientGymProgram> clientGymPrograms = clientGymProgramRepository.findAll();
        List<ClientGymProgram> values = new ArrayList<>();
        clientGymPrograms.forEach(values::add);
        final int expectedSize = 3;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkDelete() {
        clientGymProgramRepository.delete(clientGymProgram1);
        Iterable<ClientGymProgram> clientGymPrograms = clientGymProgramRepository.findAll();
        List<ClientGymProgram> values = new ArrayList<>();
        clientGymPrograms.forEach(values::add);
        final int expectedSize = 2;
        assertThat(values, hasSize(expectedSize));
    }
}
